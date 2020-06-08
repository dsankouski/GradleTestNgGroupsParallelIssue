Issue: -parallel -threadcount switches has no effect on test jar.

Steps to reproduce:
- Assemble fat jar with testNG and test classes `./gradlew clean testJar`
- Run tests in parallel with `CLASSPATH=$PWD/build/libs/autotests-fat-jar-1.0-SNAPSHOT.jar java org.testng.TestNG  -testjar $PWD/build/libs/autotests-fat-jar-1.0-SNAPSHOT.jar -parallel classes -threadcount 3`  
    - Expected result: tests run in multiple threads, each test prints own thread id
    - Actual result: tests run in single thread, each test prints same thread id

Note: if `parallel="classes" thread-count="4"` specified in testng.xml, tests run in parallel