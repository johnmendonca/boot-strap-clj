(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :asset-paths #{"assets"}
  :dependencies '[])

(task-options!
  pom  {:project 'boot-strap
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
