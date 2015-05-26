# hello_world
Simple ClojureScript project to reproduce foreign-libs bug

### Possible bug
When no optimization level is specified, the ClojureScript compiler doesn't emit a `goog.require` for foreign libraries.

### Steps
Download the standalone ClojureScript JAR:
````
$ bin/deps.sh
````

Build the project with:
````
$ java -cp cljs.jar:src clojure.main build.clj
````

The emitted JavaScript for [core.cljs](src/hello_world/core.cljs) looks like the following:
````
// Compiled by ClojureScript 0.0-3269 {}
goog.provide('hello_world.core');
goog.require('cljs.core');
cljs.core.enable_console_print_BANG_.call(null);
cljs.core.println.call(null,greeting.hello("World!"));

//# sourceMappingURL=core.js.map
````

Even though `hello-world.core` requires the foreign-lib `greeting`, the ClojureScript compiler doesn't emit a `goog.require` for `greeting`.
