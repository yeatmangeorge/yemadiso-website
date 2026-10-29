;;h1 Rewriting My Website In Clojure
;;p Today I'm going to rewrite this website in Clojure, and I want to take you along for the ride!
;;h2 Why Bother Rewriting?
;;p Currently, the website is written in Eleventy, a static website generator that creates pages from Markdown and HTML files. I did this to get something up and running quickly, and it seems like a great tool for this, I would reccomend. However, I am much more comfortable dealing with code than learning tools/frameworks, so figured it will be easy (and fun) to rewrite this site in Clojure. Additionally, it feels like this would be something that is good to do while the website is still small.
;;h2 Initial Thoughts
;;p The website design is extremely consistent. All pages have a navbar, footer, title, as well as a main content section, so we should be able to automatically generate everything but the main content. Given this, I'm ideally wanting a function that makes it really easy to define pages. Let's sketch out what it could look like.
(ns common.page)

(defn page [title description content]
  (format "
<!doctype html>
<html lang= \"en-GB\" >
<head>
<meta charset= \"utf-8\" >
<meta name= \"viewport\" content= \"width=device-width, initial-scale=1\" >
<title>%1$s</title>
<meta name=\"description\" content=\"%2$s\"
</head>
<body>
<header>
<h1>%1$s</h1>
</header>
<main>
%3$s
</main>
<footer>
</footer>
</body>
</html>
"
          title description content))

;;h2 HTML Tag Generation
;;p Now we'll need a programatic way of creating HTML. Hiccup is a Clojure standard for this, but for our purposes it's overkill. Let's just write a few small functions and get on our way.
(defn elements->str
  "Takes HTML elements as a map, and returns the resulting string ready to be inserted into HTML tag"
  [elements]
  (apply str (map (fn [[k v]]
                    (str " " (name k) "=\"" v "\""))
                  elements)))

(require '[clojure.string :as string])

(defn paired-tag
  ([tag content] (paired-tag tag {} content))
  ([tag elements content]
   (str "<" tag (elements->str elements) ">\n"
        (if (sequential? content)
          (string/join "\n" content)
          content)
        "\n</" tag ">")))

(defn void-tag
  ([tag] (void-tag tag {}))
  ([tag elements] (str "<" tag (elements->str elements) "/>")))

(defmacro deftag
  {:clj-kondo/macroexpand-hook true}
  ([tag] `(deftag ~tag true))
  ([tag paired?]
   `(def ~tag
      (partial ~(if paired? `paired-tag `void-tag)
               ~(name tag)))))

(deftag h1)
(deftag h2)
(deftag h3)
(deftag h4)
(deftag h5)
(deftag p)
(deftag div)
(deftag img false)
(deftag html)
(deftag head)
(deftag metatag false)
(deftag title)
(deftag header)
(deftag main)
(deftag body)
(deftag footer)
(deftag link false)

;;p Now we can actually rewrite our initial page implmentation using these:
(defn page [title description content]
  (str "<!doctype html>\n"
       (html {:lang "en-GB"}
             (head
              (metatag {:charset "utf-8"})))
       title description content))

(defn page [page-title page-description page-route content]
  (str "<!doctype html>\n"
       (html {:lang "en-GB"}
             [(head [(metatag {:charset "utf-8"})
                     (metatag {:name "viewport" :content "width=device-width, initial-scale=1"})
                     (title page-title)
                     (metatag {:name "description" :content page-description})
                     (link {:rel "canonical" :href (str "https://yemadiso.com/" page-route)})])
              (body [(header page-title)
                     (main content)
                     (footer [])])])))

(spit ".test.html" (page 1 2 3 4))