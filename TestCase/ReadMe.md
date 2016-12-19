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


## Basic JUnit code constructs

* Available JUnit annotations

JUnit 4.x uses annotations to mark methods as test methods and to configure them. The following table gives an overview of the most important annotations in JUnit.
Table 1. Annotations Annotation 	Description

@Test
public void method()
	

The @Test annotation identifies a method as a test method.

@Test (expected = Exception.class)
	

Fails if the method does not throw the named exception.

@Test(timeout=100)
	

Fails if the method takes longer than 100 milliseconds.

@Before
public void method()
	

This method is executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class).

@After
public void method()
	

This method is executed after each test. It is used to cleanup the test environment (e.g., delete temporary data, restore defaults). It can also save memory by cleaning up expensive memory structures.

@BeforeClass
public static void method()
	

This method is executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database. Methods marked with this annotation need to be defined as static to work with JUnit.

@AfterClass
public static void method()
	

This method is executed once, after all tests have been finished. It is used to perform clean-up activities, for example, to disconnect from a database. Methods annotated with this annotation need to be defined as static to work with JUnit.

@Ignore or @Ignore("Why disabled")
	

Ignores the test method. This is useful when the underlying code has been changed and the test case has not yet been adapted. Or if the execution time of this test is too long to be included. It is best practice to provide the optional description, why the test is disabled.

*Assert statements

JUnit provides static methods to test for certain conditions via the Assert`class. These assert statements typically start with `assert. They allow you to specify the error message, the expected and the actual result. An assertion method compares the actual value returned by a test to the expected value. It throws an AssertionException if the comparison fails.

The following table gives an overview of these methods. Parameters in [] brackets are optional and of type String.
Table 2. Methods to assert test results Statement 	Description

fail(message)
	

Let the method fail. Might be used to check that a certain part of the code is not reached or to have a failing test before the test code is implemented. The message parameter is optional.

assertTrue([message,] boolean condition)
	

Checks that the boolean condition is true.

assertFalse([message,] boolean condition)
	

Checks that the boolean condition is false.

assertEquals([message,] expected, actual)
	

Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.

assertEquals([message,] expected, actual, tolerance)
	

Test that float or double values match. The tolerance is the number of decimals which must be the same.

assertNull([message,] object)
	

Checks that the object is null.

assertNotNull([message,] object)
	

Checks that the object is not null.


assertSame([message,] expected, actual)
	

Checks that both variables refer to the same object.



assertNotSame([message,] expected, actual)
	

Checks that both variables refer to different objects.


##JUnit Rules

Via JUnit rules you can add behavior to each tests in a test class. You can annotate fields of type TestRule with the @Rule annotation. You can create objects which can be used and configured in your test methods. This adds more flexibility to your tests. You could, for example, specify which exception message you expect during the execution of your test code



For more examples of existing rules see https://github.com/junit-team/junit4/wiki/Rules.


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






 



