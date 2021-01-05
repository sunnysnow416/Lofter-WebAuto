package com.sunnysnow.utils;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Assertion {
    public static boolean flag = true;
    public static List<Error> errors = new ArrayList<Error>();

    /**
     * @param o
     * @return
     */
    public static boolean verifyTrue(boolean o) {
        try {
            Assert.assertTrue(o);
        } catch (Error e) {
//            verificationErrors.append(e.toString());
            errors.add(e);
            flag = false;
        }
        return flag;
    }

    /**
     * @param o
     * @return
     */
    public static boolean verifyFalse(boolean o) {
        try {
            Assert.assertFalse(o);
        } catch (Error e) {
//            verificationErrors.append(e.toString());
            errors.add(e);
            flag = false;
        }
        return flag;
    }

    /**
     * @param actual
     * @param expected
     * @return
     */
    public static boolean verifyEquals(Object actual, Object expected) {
//		flag = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Error e) {
            errors.add(e);
            flag = false;
        }
        return flag;
    }

    /**
     * @param actual
     * @param expected
     * @param message
     */
    public static void verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (Error e) {
            errors.add(e);
            flag = false;
        }

    }

    /**
     * @param actual
     * @param message
     */
    public static void verifyNulls(Object actual, String message) {
        try {
            Assert.assertNull(actual, message);
        } catch (Error e) {
            errors.add(e);
            flag = false;
        }
    }

}
