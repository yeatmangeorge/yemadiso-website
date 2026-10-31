(ns common.discovery
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [clojure.java.shell :refer [sh]]))

(defn project-root []
  (-> (sh "git" "rev-parse" "--show-toplevel")
      :out
      str/trim
      io/file))

(defn page-relpaths
  "Returns relative filepaths to each .clj file in src/page."
  []
  (let [root (io/file (project-root) "src/page")]
    (->> (file-seq root)
         (filter #(.isFile %))
         (filter #(str/ends-with? (str %) ".clj"))
         (map #(.relativize (.toPath root) (.toPath %)))
         (map str))))