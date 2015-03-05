(set-env!
  :source-paths #{"src"}
  :dependencies '[[me.raynes/conch  "0.8.0"]])

(task-options!
  pom  {:project 'thy-strap
        :version  "0.1.0"}
  jar  {:manifest  {"Foo"  "bar"}})

(deftask null []
  (fn [next-task]
    (fn [fileset]
      (println *ns*)
      (println (clojure-version))
      (next-task fileset))))

(deftask build
  "Build my project, son."
  []
  (comp (null) (aot :all true) (pom) (jar)))
