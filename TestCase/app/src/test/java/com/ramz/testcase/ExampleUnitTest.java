package com.ramz.testcase;

import com.ramz.testcase.util.EmailValidator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    boolean isTrue=true;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(EmailValidator.isValidEmail("kk@gmail.com"), is(true));
    }

    @Test
    public void TestString()
    {
//        assertThat(isTrue==true,is(true));
        assertNotEquals(isTrue=false,true);
    }





}