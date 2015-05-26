(ns hello-world.core
  (:require [greeting :as greeting]))

(enable-console-print!)

(println (.hello js/greeting "World!"))
