package za.ac.nwu.ac.logic.flow.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModuloTest {

    private Modulo mod;

    @Before
    public void setUp() throws Exception
    {
        mod = new Modulo();
    }

    @Test
    public void testMod() throws Exception {
        Integer result = mod.doMod(9, 5);
        assertNotNull("Should not be null", result);
        assertEquals("Should be value 4", 4, result.intValue());
    }

    /*@Test                                     //If the divisor is 0
    public void testModBy0()
    {
        Integer result = mod.doMod(9, 0);
        assertNull("Should be null", result);
    }*/

    @Test ()
    public void testModBy0() {
        try{
            mod.doMod(9, 0);
            fail("Should throw an exception");
        }catch (Exception e)
        {
            assertTrue("Error message not as expected",e.getMessage().equalsIgnoreCase("Failed for some reason"));
        }

    }



}
