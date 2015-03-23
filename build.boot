(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :asset-paths #{"assets"}
  :dependencies '[[org.pegdown/pegdown  "1.5.0"]
                  [org.clojure/tools.namespace  "0.2.10"]])

(task-options!
  pom  {:project 'boot-static
        :version  "0.1.0"})

(deftask null []
  (fn [next-task]
    (fn [fileset]
      (println *ns*)
      (println (clojure-version))
      (next-task fileset))))

(deftask build
  "Build my project"
  []
  (comp (null) (aot :all true) (pom) (jar)))
