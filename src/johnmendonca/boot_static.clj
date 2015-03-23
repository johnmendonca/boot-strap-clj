(ns johnmendonca.boot-static
  {:boot/export-tasks true}
  (:require [clojure.set :as set]
            [clojure.pprint :refer [pprint]]
            [boot.core :refer [deftask input-files output-files]]))

(deftask lol []
  (fn [next-task]
    (fn [fileset]
      (pprint (input-files fileset))
      (println "\n")
      (pprint (output-files fileset))
      (println "\n")
      (pprint (set/intersection (output-files fileset) (input-files fileset)))
      (println "\n")
      (next-task fileset))))

