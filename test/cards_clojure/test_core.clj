(ns cards-clojure.test_core
  (:require [clojure.test :as t]
            [cards-clojure.core :refer :all]))

(def flush-hand #{{:suit :clubs
                   :rank 2}
                  {:suit :clubs
                   :rank 3}
                  {:suit :clubs
                   :rank 6}
                  {:suit :clubs
                   :rank 8}})              

(def straight-hand #{{:suit :diamonds
                      :rank 2}
                     {:suit :clubs
                      :rank 3}
                     {:suit :clubs
                      :rank 4}
                     {:suit :clubs
                      :rank 5}})

(def straight-flush-hand #{{:suit :clubs
                            :rank 2}
                           {:suit :clubs
                            :rank 3}
                           {:suit :clubs
                            :rank 4}
                           {:suit :clubs
                            :rank 5}})

(def pair-hand #{{:suit :diamonds
                  :rank 2}
                 {:suit :clubs
                  :rank 2}
                 {:suit :clubs
                  :rank 3}
                 {:suit :clubs
                  :rank 4}})

(def three-hand #{{:suit :diamonds
                   :rank 2}
                  {:suit :clubs
                   :rank 2}
                  {:suit :hearts
                   :rank 2}
                  {:suit :clubs
                   :rank 4}}) 

(def four-hand #{{:suit :diamonds
                  :rank 1}
                 {:suit :clubs
                  :rank 1}
                 {:suit :hearts
                  :rank 1}
                 {:suit :spades
                  :rank 1}})

(def two-pair-hand #{{:suit :diamonds
                      :rank 2}
                     {:suit :clubs
                      :rank 2}
                     {:suit :hearts
                      :rank 1}
                     {:suit :spades
                      :rank 1}})
(t/deftest flush-test
    (t/is (= true (flush? flush-hand)))
    (t/is (= false (flush? straight-hand))))

(t/deftest straight-test
    (t/is (= false (straight? flush-hand)))
    (t/is (= true (straight? straight-hand))))

(t/deftest straight-flush-test
    (t/is (= false (straight-flush? flush-hand)))
    (t/is (= true (straight-flush? straight-flush-hand))))

(t/deftest four-of-a-kind-test
    (t/is (= false (four-of-a-kind? flush-hand)))
    (t/is (= true (four-of-a-kind? four-hand))))

(t/deftest three-of-a-kind-test
    (t/is (= false (three-of-a-kind? flush-hand)))
    (t/is (= true (three-of-a-kind? three-hand))))

(t/deftest two-of-a-kind-test
    (t/is (= false (two-of-a-kind? flush-hand)))
    (t/is (= true (two-of-a-kind? pair-hand))))

(t/deftest two-of-a-kind-test
    (t/is (= false (two-of-a-kind? flush-hand)))
    (t/is (= true (two-of-a-kind? pair-hand))))

(t/deftest two-pair-test
    (t/is (= false (two-pair? flush-hand)))
    (t/is (= true (two-pair? two-pair-hand))))

















