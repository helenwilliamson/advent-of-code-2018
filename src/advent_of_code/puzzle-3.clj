(ns advent-of-code.puzzle-3
  (:gen-class)
  (require [clojure.string :as str]))

(defn tokenise
  [line]
  (let [parts (str/split line #" ")
        id (Integer/parseInt (subs (parts 0) 1))
        x-y (str/split (parts 2) #",")
        x (Integer/parseInt (x-y 0))
        y (Integer/parseInt (str/replace (x-y 1) ":" ""))
        dimensions (str/split (parts 3) #"x")
        width (Integer/parseInt (dimensions 0))
        height (Integer/parseInt (dimensions 1))]
    {:id id :x x :y y :width width :height height}))

(defn read-input
  []
  (->> (slurp "resources/puzzle-3")
       (str/split-lines)
       (map tokenise)))

(def dummy
  (map tokenise ["#1 @ 1,3: 4x4" "#2 @ 3,1: 4x4" "#3 @ 5,5: 2x2"]))

(defn generate-coordinates
  [claim]
  (let [first ()]))

(defn part-1
  [inputs]
  )
