# Ktor - Vue.js + TypeScript - Type Sharing

### Description
This is an example project for using the new IR compiler of kotlin. Defined classes
from the <b>shared</b> are distributed to the server and client at the same time using the IR compiler for the client 
and manipulating the source files directly for the server (without compilation).

### Prerequisites
Following tools should be installed on your machine (only tested on Ubuntu):
- Locally installed Gradle
- Locally installed Yarn
- Java 8 & 11

### Getting Started
- After clone `gradle bundle` in <b>root</b> directory once.

### Development

You will actually need 4 terminals to archive hot reloading while coding, all this is a bit tricky, so it might not be the perfect live reloading experience.

- Terminal 1: `gradle -t build` in  <b>shared</b> directory
- Terminal 2: `gradle -t installDist` in  <b>server</b> directory
- Terminal 3: `gradle run` in  <b>server</b> directory
- Terminal 4: `yarn serve` in  <b>client</b> directory

### Production
To built fat-JAR-file will include everything to just copy the file to some server and run it.
- Run `gradle bundle` in <b>root</b> directory to build.
To execute the jar file run `java -jar build/server-0.0.1.jar`. This will try running on Port 80 (as it's production),
  if you want to test locally run `java -jar build/server-0.0.1.jar -port=SOME_PORT`. 