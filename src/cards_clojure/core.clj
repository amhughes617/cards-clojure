(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])
(def ranks (range 1 14))
(def rank-names {1 :ace 11 :jack 12 :queen 13 :king})

(defn create-deck []
  (set
    (for [suit suits
          rank ranks]
      {:suit suit
       :rank rank})))

(defn create-hands [deck]
  (set
    (for [c1 deck
          c2 (disj deck c1)
          c3 (disj deck c2 c1)
          c4 (disj deck c1 c2 c3)]
      #{c1 c2 c3 c4})))
      
(defn flush? [hand]
  (= 1 (count (set (map :suit hand)))))   

(defn straight? [hand]
  (let [hand-ranks (sort (map :rank hand))
        first (first hand-ranks)
        last (last hand-ranks)]
    (and (= 4 (count (set hand-ranks))) (= 3 (- last first)))))
(defn straight-flush? [hand]
  (and (straight? hand) (flush? hand)))

(defn four-of-a-kind? [hand]
  (= 1 (count (set (map :rank hand)))))

(defn three-of-a-kind? [hand]
  (let [freq-vals (set (vals (frequencies (map :rank hand))))]
    (contains? freq-vals 3)))

(defn two-of-a-kind? [hand]
  (let [freq-vals (set (vals (frequencies (map :rank hand))))]
    (= 3 (apply + freq-vals))))

(defn two-pair? [hand]
  (let [freq-vals (vals (frequencies (map :rank hand)))]
    (= '(2 2) freq-vals)))

(defn -main []
    (let [deck (create-deck)
          hands (create-hands deck)
          flush-hands (set (filter two-pair? hands))]
      (println (count flush-hands))
      (println (count (set hands)))))
