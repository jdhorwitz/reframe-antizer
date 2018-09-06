(ns app.views
  (:require
   [re-frame.core :as re-frame]
   [app.subs :as subs]
   [app.events :as events]
   [antizer.reagent :as ant]))

;; home

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

;; Josh panel

(defn josh-panel []
  [:div
   [:h1 "JOSH PAGE IN DA HOUSE"]

   [:div
    [:a {:href "#/"}
     "go to Home Page"]]])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:href "#/"}
     "go to Home Page"]]])

(defn side-panel []
  [:div
    [:h2 "Side Panel"]])

;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :josh-panel [josh-panel]
    [:div]))

(defn show-panel [panel-name]
  [:div
   [ant/layout {:className "layout"
                :style {:height "100vh"}}
    [ant/layout-header 
      [:div {:className "logo"}]
      [ant/menu {:theme "dark"
                 :mode "horizontal"
                 :defaultSelectedKeys ["1"]
                 :style {:lineHeight "64px"}}
        [ant/menu-item {:key 1} [:a {:href "#/"} "Home"]]
        [ant/menu-item {:key 2} [:a {:href "#/about"} "About"]]
        [ant/menu-item {:key 3} [:a {:href "#/josh"} "Josh"]]]]
    [ant/layout-content {:style {:padding "0 50px"}}
     [:div {:style {:margin "16px 0"}}]
     [:div {:style {:background "#fff"
                     :padding 24
                     :minHeight 280}}
     [panels panel-name]]]
    [ant/layout-footer {:style {:textAlign "center"}} "Proud Parents of Loss ©2018"]]])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
