package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;                       //Alt+Enter to add dependency (But had issues so created dependency manually)
public class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new FetchAccountTypeFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    @Test
    public void methodToTest() {
        assertTrue(classToTest.methodToTest());
    }
}