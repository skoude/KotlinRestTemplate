**KotlinRestTemplate**

This project contains a basic template for building microservices  and REST -services by using Kotlin and Spark Micro framework

Components and libraries used:
* [Spark Micro framework](http://sparkjava.com)
* [Kotlin](https://kotlinlang.org)
* [Jackson FasterXML for handling Json](https://github.com/FasterXML/jackson)
* [Junit - testing framework](http://junit.org/junit4/)
* [SLF4J - Simple logging facade for java](http://www.slf4j.org)
* [Kotlin logging](https://github.com/MicroUtils/kotlin-logging)


Just clone this repo, and run
* `./gradlew build`
* `./gradlew run`



Now your server should be started.. 
Just open your browser and try: [http://localhost:4567/hello](http://localhost:4567/hello)

If you wan't to run just the tests, just execute:
* `./gradlew test`

`Main.kt` contains all the routes. 
