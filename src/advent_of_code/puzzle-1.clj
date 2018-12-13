(ns advent-of-code.puzzle-1
  (:gen-class)
  (require [clojure.string :as str]))

(defn input
  []
  (->> (slurp "resources/puzzle-1")
       (str/split-lines)
       (map #(Integer/parseInt %))))

(defn calculate-frequence-1
  []
  (->> (input)
       (reduce +)))

(def input-2 [+3 +3 +4 -2 -4])

(defn calculate-frequence-2
  []
  (loop [inputs (cycle (input))
         calculated #{0}
         last 0]
    (let [next-input (first inputs)
          next-value (+ next-input last)]
      (if (contains? calculated next-value)
        next-value
        (recur (rest inputs) (conj calculated next-value) next-value)))))
