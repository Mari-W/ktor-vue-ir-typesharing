# Ktor - Vue.js + TypeScript - Type Sharing

### Description
This is an example project for using the new IR compiler of kotlin. Defined classes
from the shared project are distributed to the server and client at the same time using the IR compiler for the client (to create TypeScript Definition files)
and normal JVM compilation for server side (to create a local dependency).

### Prerequisites
Following tools should be installed on your machine (only tested on Ubuntu):
- Locally installed Yarn
- Java 8 & 11

### Getting Started
Directly after a clone you have to initiate one first build:
- In root directory run `gradle bundle` or `./gradlew bundle`.

### Development

You will actually need 4 terminals to archive hot reloading while coding.

- In shared dir run : `gradle -t build` or in root dir run: `./gradlew -t :shared:build` 
- In server dir run: `gradle -t installDist` or in root dir run: `./gradlew -t :server:installDist` 
- In server dir run: `gradle -t run` or in root dir run: `./gradlew -t :server:run` 
- in client dir run: `yarn serve` or in root dir run: `yarn --cwd client serve` 

### Production
-  In root directory run `gradle bundle` or `./gradlew bundle`.

This will create a fat-jar file including everything. In production the built Vue project is served by Ktor itself. 

To execute the jar file run `java -jar build/server-0.0.1.jar`. This will try running on Port 80 (as it's production),
  if you want to test locally run `java -jar build/server-0.0.1.jar -port=SOME_PORT`. 
