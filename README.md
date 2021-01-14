# Ktor - Vue.js + TypeScript - Type Sharing

### Description
This is an example project for using the new IR compiler of kotlin. Defined classes
from the <b>shared</b> directory are distributed to the server and client at the same time using the IR compiler for the client (to create TypeScript Definition files)
and manipulating the source files directly for the server (without compilation).

### Prerequisites
Following tools should be installed on your machine (only tested on Ubuntu):
- Locally installed Gradle
- Locally installed Yarn
- Java 8 & 11

### Getting Started
Directly after a clone you have to initiate one first build:
- In <b>root</b> directory run `gradle bundle`.

### Development

You will actually need 4 terminals to archive hot reloading while coding, all this is a bit tricky, so it might not be the perfect live reloading experience.

- In <b>shared</b> directory run : `gradle -t build`
- In <b>server</b> directory run: `gradle -t installDist`
- In <b>server</b> directory run: `gradle run`
- in <b>client</b> directory run: `yarn serve`

### Production
To built fat-JAR-file will include everything to just copy the file to some server and run it.
-  In <b>root</b> directory run `gradle bundle`.
To execute the jar file run `java -jar build/server-0.0.1.jar`. This will try running on Port 80 (as it's production),
  if you want to test locally run `java -jar build/server-0.0.1.jar -port=SOME_PORT`. 