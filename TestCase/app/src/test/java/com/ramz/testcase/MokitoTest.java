package com.ramz.testcase;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import android.content.Context;

import com.ramz.testcase.util.MokitoTestRun;



//Run with is the frame work you like to use Mockito is highly used
@RunWith(MockitoJUnitRunner.class)
public class MokitoTest {
    private static final String FAKE_STRING = "HELLO WORLD";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        when(mMockContext.getString(R.string.hello_word))
                .thenReturn(FAKE_STRING);

        MokitoTestRun myObjectUnderTest = new MokitoTestRun(mMockContext);

        // ...when the string is returned from the object under test...
        String result = myObjectUnderTest.getHelloWorldString();

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }

}
