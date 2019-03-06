package com.addtrycatchplugin;

import android.util.Log;

/**
 * @author xc
 * @time 19-3-1.
 */
public class ExceptionUtils {

    public static void uploadCatchedException(Exception exception) {
        if (null == exception) {
            return;
        }
        Log.e("ExceptionUtilsTAG", "uploadCatchedException", exception);
    }
}
