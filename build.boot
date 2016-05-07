(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :asset-paths #{"assets"}
  :dependencies '[[adzerk/boot-cljs "1.7.228-1" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]])

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
  (comp (null) (cljs :optimizations :advanced) (aot :all true) (pom) (jar) (target)))
