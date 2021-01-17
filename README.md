# Ktor - Vue.js + TypeScript - Type Sharing

### Description
This is an example project for using the new IR compiler of kotlin. Defined classes
from the <b>shared</b> directory are distributed to the server and client at the same time using the IR compiler for the client (to create TypeScript Definition files)
and normal JVM compilation for server side (to create a local dependency).

### Prerequisites
Following tools should be installed on your machine (only tested on Ubuntu):
- Locally installed Yarn
- Java 8 & 11

### Getting Started
Directly after a clone you have to initiate one first build:
- In <b>root</b> directory run `gradle bundle` or `./gradlew bundle`.

### Development

You will actually need 4 terminals to archive hot reloading while coding, all this is a bit tricky, so it might not be the perfect live reloading experience.

- In <b>shared</b> directory run : `gradle -t build` or `./gradlew -t :shared:build` in <b>root</b>
- In <b>server</b> directory run: `gradle -t installDist` or `./gradlew -t :server:installDist` in <b>root</b>
- In <b>server</b> directory run: `gradle -t run` or `./gradlew -t :server:run` in <b>root</b>
- in <b>client</b> directory run: `yarn serve` or `yarn --cwd client serve`  in <b>root</b>

### Production
To built fat-JAR-file will include everything to just copy the file to some server and run it.
-  In <b>root</b> directory run `gradle bundle` or `./gradlew bundle`.
To execute the jar file run `java -jar build/server-0.0.1.jar`. This will try running on Port 80 (as it's production),
  if you want to test locally run `java -jar build/server-0.0.1.jar -port=SOME_PORT`. 
