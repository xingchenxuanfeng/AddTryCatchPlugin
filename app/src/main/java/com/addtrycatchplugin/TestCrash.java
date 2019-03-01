package com.addtrycatchplugin;

import android.util.Log;

/**
 * @author xc
 * @time 19-3-1.
 */
public class TestCrash {
    public static void crashMethod1() {
        int a = 1 / 0;
        Log.e("TestCrash", "crashMethod1 " + a);
    }

    public static void crashMethod2() {
        int a = 1 / 0;
        Log.e("TestCrash", "crashMethod2 " + a);
    }
}
