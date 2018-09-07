(ns app.components.home
  (:require
   [re-frame.core :as re-frame]
   [app.subs :as subs]
   [app.events :as events]
   [antizer.reagent :as ant]))

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div {:style {:textAlign "center"}}
     [:h1 (str "Hello from " @name ". This is the Home Page.")]
     [ant/button
      {:on-click #(re-frame/dispatch [::events/set-name "Josh"])}
      "My Name is Josh"]
     [ant/button
      {:on-click #(re-frame/dispatch [::events/set-name "Amber"])}
      "Who My Wife?"]]))
