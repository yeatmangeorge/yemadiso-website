(ns common.route
  (:require
   [clojure.string :as str]
   [common.discovery :as discovery]))

(defn- relpath->route-symbol [relpath]
  (-> relpath
      str/lower-case
      (str/replace #"/" ".")
      (str/replace #".clj" "")
      symbol))

(defn- relpath->relurl [relpath]
  (-> relpath
      str/lower-case
      (str/replace #"_" "-")
      (str/replace #".clj" "")
      (str "/")))

(defn- defroute [relpath]
  (let [route-symbol (relpath->route-symbol relpath)]
    (println (str "Registering route: " route-symbol))
    (intern *ns* route-symbol (relpath->relurl relpath))))

(doseq
 [relpath (discovery/page-relpaths)]
  (defroute relpath))
