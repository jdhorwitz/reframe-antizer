(ns upvote.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [upvote.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 2 2))))
