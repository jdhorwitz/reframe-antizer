(ns app.views
  (:require
   [re-frame.core :as re-frame]
   [app.subs :as subs]
   [app.events :as events]
   [app.components.layout :refer [layout]]
   [antizer.reagent :as ant]))

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [layout @active-panel]))
