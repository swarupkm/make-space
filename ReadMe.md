# Make Space

The problem statement solved is `https://www.geektrust.com/challenge/make-space`

# Pre-requisites
* Java 1.11
* Gradle 6

# How to run the code

 * `./gradlew clean build -x test --no-daemon` - This will create a jar file `geektrust.jar` in the `build/libs` folder.
 * `java -jar build/libs/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

 # How to execute the unit tests

 `./gradlew clean test --no-daemon` will execute the unit test cases.
