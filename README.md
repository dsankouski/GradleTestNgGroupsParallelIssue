Issue: Tests run in one thread, if class with specific name present

Try to run tests in groups TEST2 in parallel: `./gradlew cleanTest test -Pparallel.forkCount=2 -Pgroups=TEST2`
Expected result: Tests run in parallel on two executors
Actual result: Tests run on 1 executor: 
```$xslt
Running tests with groups: [TEST2]

> Task :test

Gradle suite > Gradle test > TestClass1 > test1 STANDARD_OUT
    Gradle test worker is: 25
    test 1 is launched

Gradle suite > Gradle test > TestClass1 > test1 STANDARD_OUT
    Gradle test worker is: 25
    test 1 is launched

Gradle suite > Gradle test > TestClass1 > test1 STANDARD_OUT
    Gradle test worker is: 25
    test 1 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 25
    test 2 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 25
    test 2 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 25
    test 2 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 25
    test 2 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 25
    test 2 is launched

```

Now delete or rename HaulageTest class and run same command:
Actual result: 
```$xslt
Running tests with groups: [TEST2]

> Task :test

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 28
    test 2 is launched

Gradle suite > Gradle test > TestClass1 > test1 STANDARD_OUT
    Gradle test worker is: 27
    test 1 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 28
    test 2 is launched

Gradle suite > Gradle test > TestClass1 > test1 STANDARD_OUT
    Gradle test worker is: 27
    test 1 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 28
    test 2 is launched

Gradle suite > Gradle test > TestClass1 > test1 STANDARD_OUT
    Gradle test worker is: 27
    test 1 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 28
    test 2 is launched

Gradle suite > Gradle test > TestClass2 > test2 STANDARD_OUT
    Gradle test worker is: 28
    test 2 is launched

```

Tested on gradle 6.1, 6.5 versions, and testNG 6.14.3 and 7.1.0