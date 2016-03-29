(ns cards-clojure.test-core
  (:require [:use clojure.test]
            [:use cards-clojure.core]))

(def flush #{{:suit :clubs
              :rank 2}
             {:suit :clubs
              :rank 3}
             {:suit :clubs
              :rank 6}
             {:suit :clubs
              :rank 8}})              

(def straight #{{:suit :diamonds
                 :rank 2}
                {:suit :clubs
                 :rank 3}
                {:suit :clubs
                 :rank 4}
                {:suit :clubs
                 :rank 5}})

(def straight-flush #{{:suit :clubs
                       :rank 2}
                      {:suit :clubs
                       :rank 3}
                      {:suit :clubs
                       :rank 4}
                      {:suit :clubs
                       :rank 5}})

(def pair #{{:suit :diamonds
             :rank 2}
            {:suit :clubs
             :rank 2}
            {:suit :clubs
             :rank 3}
            {:suit :clubs
             :rank 4}})

(def three #{{:suit :diamonds
              :rank 2}
             {:suit :clubs
              :rank 2}
             {:suit :clubs
              :rank 3}
             {:suit :clubs
              :rank 4}}) 

(def four #{{:suit :diamonds
             :rank 1}
            {:suit :clubs
             :rank 1}
            {:suit :hearts
             :rank 1}
            {:suit :spades
             :rank 1}})

(def two-pair #{{:suit :diamonds
                 :rank 2}
                {:suit :clubs
                 :rank 2}
                {:suit :hearts
                 :rank 1}
                {:suit :spades
                 :rank 1}})
(deftest flush-test
    (is (= true (flush? flush)))
    (is (= false (flush? straight))))

(deftest straight-test
    (is (= false (straight? flush)))
    (is (= true (straight? straight))))

(deftest straight-flush-test
    (is (= false (straight-flush? flush)))
    (is (= true (straight-flush? straight-flush))))

(deftest four-of-a-kind-test
    (is (= false (four-of-a-kind? flush)))
    (is (= true (four-of-a-kind? four))))

(deftest three-of-a-kind-test
    (is (= false (three-of-a-kind? flush)))
    (is (= true (three-of-a-kind? three))))

(deftest two-of-a-kind-test
    (is (= false (two-of-a-kind? flush)))
    (is (= true (two-of-a-kind? pair))))

(deftest two-of-a-kind-test
    (is (= false (two-of-a-kind? flush)))
    (is (= true (two-of-a-kind? two))))

(deftest two-pair-test
    (is (= false (two-pair? flush)))
    (is (= true (two-pair? two-pair))))

















