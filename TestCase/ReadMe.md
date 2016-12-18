Android tests are based on JUnit, and you can run them either as local unit tests on the JVM or as instrumented tests on an Android device. This page provides an introduction to the concepts and tools for building Android tests.
Test Types

When using Android Studio to write any of your tests, your test code must go into one of two different code directories (source sets). For each module in your project, Android Studio includes both source sets, corresponding to the following test types:

##Local unit tests

Located at module-name/src/test/java/.

These tests run on the local JVM and do not have access to functional Android framework APIs.


##Mockito(Highly Used Jtest Framework)

Mockito is an open source testing framework for Java released under the MIT License.The framework allows the creation of test double objects (mock objects) in automated unit tests for the purpose of Test-driven Development (TDD) or Behavior Driven Development (BDD).

In software development there is an opportunity of ensuring that objects perform the behaviors that are expected of them. One approach is to create a test automation framework that actually exercises each of those behaviors and verifies that it performs as expected, even after it is changed. However, the requirement to create an entire testing framework is often an onerous task that requires as much effort as writing the original objects that were supposed to be tested. For that reason, developers have created mock testing frameworks. These effectively fake some external dependencies so that the object being tested has a consistent interaction with its outside dependencies. Mockito intends to streamline the delivery of these external dependencies that are not subjects of the test. A study performed in 2013 on 10,000 GitHub projects found that Mockito is the 9th most popular Java library



