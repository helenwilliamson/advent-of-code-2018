(ns advent-of-code.puzzle-2
  (:gen-class)
  (require [clojure.string :as str]))

(defn input
  []
  (->> (slurp "resources/puzzle-2")
       (str/split-lines)))

(def a-z (map char (range 97 123)))

(defn n-of-letters
  [input number]
  (->> (filter #(some (fn [letter] (n-of-a-letter %1 letter number)) a-z) input)
       (count)))

(defn n-of-a-letter
  [word letter number]
  (= number (count (filter #(= %1 letter) word))))

(defn part-1
  []
  (let [inputs (input)]
    (* (n-of-letters inputs 2) (n-of-letters inputs 3))))

(defn difference
  [word1 word2]
  (->> (map vector word1 word2)
       (filter #(= (first %1) (second %1)))
       (map #(first %1))
       (str/join)))

(defn differ-by-one
  [word1 word2]
  (loop [w1 word1
         w2 word2
         differs-by 0]
    (if (empty? w1)
      (difference word1 word2)
      (let [letter-1 (first w1)
            letter-2 (first w2)]
        (if (or (= letter-1 letter-2) (and (not= letter-1 letter-2) (= differs-by 0)))
          (let [increase (if (= letter-1 letter-2) 0 1)]
            (recur (rest w1) (rest w2) (+ increase differs-by)))
          nil)))))

(defn check-word
  [word inputs]
  (some #(differ-by-one word %1) inputs))

(def test-values ["abcde" "fghij" "klmno" "pqrst" "fguij" "axcye" "wvxyz"])

(defn part-2
  [inputs]
  (loop [word (first inputs)
         words (rest inputs)]
    (let [result (check-word word words)]
      (if (empty? result)
        (recur (first words) (rest words))
        result))))
