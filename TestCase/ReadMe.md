 Android tests are based on JUnit, and you can run them either as local unit tests on the JVM or as instrumented tests on an Android device. This page provides an introduction to the concepts and tools for building Android tests.
Test Types

When using Android Studio to write any of your tests, your test code must go into one of two different code directories (source sets). For each module in your project, Android Studio includes both source sets, corresponding to the following test types:

Local unit tests

Located at module-name/src/test/java/.

These tests run on the local JVM and do not have access to functional Android framework APIs.
