Android tests are based on JUnit, and you can run them either as local unit tests on the JVM or as instrumented tests on an Android device. This page provides an introduction to the concepts and tools for building Android tests.
Test Types

When using Android Studio to write any of your tests, your test code must go into one of two different code directories (source sets). For each module in your project, Android Studio includes both source sets, corresponding to the following test types:

##Local unit tests

Located at module-name/src/test/java/.

These tests run on the local JVM and do not have access to functional Android framework APIs.


##Mockito(Highly Used Jtest Framework)

Mockito is an open source testing framework for Java released under the MIT License.The framework allows the creation of test double objects (mock objects) in automated unit tests for the purpose of Test-driven Development (TDD) or Behavior Driven Development (BDD).

In software development there is an opportunity of ensuring that objects perform the behaviors that are expected of them. One approach is to create a test automation framework that actually exercises each of those behaviors and verifies that it performs as expected, even after it is changed. However, the requirement to create an entire testing framework is often an onerous task that requires as much effort as writing the original objects that were supposed to be tested. For that reason, developers have created mock testing frameworks. These effectively fake some external dependencies so that the object being tested has a consistent interaction with its outside dependencies. Mockito intends to streamline the delivery of these external dependencies that are not subjects of the test. A study performed in 2013 on 10,000 GitHub projects found that Mockito is the 9th most popular Java library




##Use of JUnit

Add dependency

    dependencies {
   
    // Required -- JUnit 4 framework
    testCompile 'junit:junit:4.12'
    // Optional -- Mockito framework
    testCompile 'org.mockito:mockito-core:1.10.19'
    }

Write Test case with '@Test'



Run Local Unit Tests

To run your local unit tests, follow these steps:

    Be sure your project is synchronized with Gradle by clicking Sync Project in the toolbar.
    Run your test in one of the following ways:
        To run a single test, open the Project window, and then right-click a test and click Run .
        To test all methods in a class, right-click a class or method in the test file and click Run .
        To run all tests in a directory, right-click on the directory and select Run tests .

The Android Plugin for Gradle compiles the local unit test code located in the default directory (src/test/java/), builds a test app, and executes it locally using the default test runner class. Android Studio then displays the results in the Run window. 


## Using Mockito

Mockito supports the creation of mock objects. For this you can use the static mock() method.

Mockito also supports the creation of mock objects based on the @Mock annotation.

If you use this annotation, you must initialize the mock objects. The MockitoRule allows this. It invokes the static method MockitoAnnotations.initMocks(this) to populate the annotated fields. Alternatively you can use @RunWith(MockitoJUnitRunner.class)

@Mock- Tells Mockito to mock the give value

eg:@Mock
    Context mMockContext;(Tells Mockito to mock the mMockContext
 instance)


@Before- When writing tests, it is common to find that several tests need similar objects created before they can run @Before is used for that.






 



