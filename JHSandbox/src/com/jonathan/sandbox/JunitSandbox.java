package com.jonathan.sandbox;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by Jonathan on 2/5/2016.
 */
public class JunitSandbox {

    @Test
    public void assertEqualsSandbox1(){
        //Demonstrating assertEquals
        TestCase testCase = new TestCase();

        assertEquals(1, testCase.getNumber());//passes

        testCase.setNumber(5);
        assertEquals(5,testCase.getNumber());//passes


    }

    @Test
    public void assertEqualsSandbox2(){
        //demonstrating a failed test case
        TestCase testCase = new TestCase();
        assertEquals(2, testCase.getNumber());//fails
    }

    @Test
    public void assertArrayEquals(){
        //demonstrating assertArrayEquals
        TestCase testCase = new TestCase();

        int[] intArray = {0,1,2,3,4,5};

        Assert.assertArrayEquals(intArray,testCase.getIntArray());//This one required the Assert. in front of it, not sure why

        // demonstrating testing with reflection
        try {
            Field privateField = TestCase.class.getDeclaredField("intArray");
            privateField.setAccessible(true);
            // get the value of this private field
            int[] fieldValue = (int[]) privateField.get(testCase);

            Assert.assertArrayEquals(intArray,fieldValue);

        } catch (NoSuchFieldException e) {
            System.out.println(e.toString());
        } catch (IllegalAccessException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void assertFalseSandbox(){
        TestCase testCase = new TestCase();

        assertFalse(testCase.getState());// passes
    }

    @Test
    public void assertTrueSandbox(){
        TestCase testCase = new TestCase();

        Assert.assertTrue(testCase.getState());//fails
    }

    @Test
    public void assertNotNullSandbox(){
        TestCase testCase = new TestCase();

        assertNotNull(testCase.getNameTwo());//fails
    }

    @Test
    public void assertNullSandbox(){
        TestCase testCase = new TestCase();

        assertNull(testCase.getNameTwo());//passes
    }

    @Test
    public void assertSameSandbox(){
        TestCase testCase = new TestCase();
        TestCase testCase1 = testCase;
        TestCase testCase2 = new TestCase();

        assertSame(testCase,testCase1);//passes
        assertSame(testCase,testCase2);//fails
    }

    @Test
    public void assertNotSameSandbox(){
        TestCase testCase = new TestCase();
        TestCase testCase2 = testCase;
        TestCase testCase3 = new TestCase();

        assertSame(testCase,testCase2);//fails
        assertSame(testCase,testCase3);//passes
    }

    //testing the fail() methid
    @Test
    public void failSandbox(){

        assertEquals(1,1);//this passes, but I want it to fail anyways
        fail();
    }

    //test to make sure an exception was thrown
    @Test
    public void exceptionSandbox(){

        try{
            TestCase testCase = new TestCase();
            testCase.exceptionThrower();
            fail();
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

}
