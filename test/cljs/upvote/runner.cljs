(ns upvote.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [upvote.core-test]))

(doo-tests 'upvote.core-test)
