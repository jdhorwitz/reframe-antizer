(ns app.components.layout
  (:require
   [app.components.josh :refer [josh-panel]]
   [app.components.about :refer [about-panel]]
   [app.components.home :refer [home-panel]]
   [antizer.reagent :as ant]))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :josh-panel [josh-panel]
    [:div]))

(defn layout [panel-name]
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
