package com.ramz.testcase;

import com.ramz.testcase.util.ExceptionTestRun;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by munnaz on 19/12/16.
 */

public class RuleTest {

    @Rule
    public ExpectedException mTestException=ExpectedException.none();

    @Test
    public void testingExceptionWithRule()
    {
        mTestException.expect(IllegalArgumentException.class);
        mTestException.expectMessage("illegal argument Found");
        ExceptionTestRun tester = new ExceptionTestRun();
        tester.multiply(1000, 5);//This will a test fail cause it will not throw illegal exception
    }




    /*Rule for file operation*/
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFolder = folder.newFolder("newfolder");
        File createdFile = folder.newFile("myfilefile.txt");
        assertTrue(createdFile.exists());
//        assertTrue(!(createdFile.exists())); //this will make test fail
    }

    @Rule
    public MyCustomRule mRule=new MyCustomRule();


    @Test
    public void TestCustumRule()
    {
        boolean status=mRule.getBoolen();
        assertFalse(status);
        //        assertTrue(status); //this will make test fail

    }
}
