package com.ramz.testcase;

import com.ramz.testcase.util.ExceptionTestRun;

import org.junit.Test;

/**
 * Created by munnaz on 19/12/16.
 */

public class ExceptionTestCase {


    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown() {
        ExceptionTestRun tester = new ExceptionTestRun();
        tester.multiply(1000, 5);
    }


}
