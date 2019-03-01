package com.addtrycatchplugin;

import android.util.Log;

/**
 * @author xc
 * @time 19-3-1.
 */
public class ExceptionUtils {

    public static void uploadCatchedException(Throwable throwable) {
        if (null == throwable) {
            return;
        }
        Log.e("ExceptionUtilsTAG", "uploadCatchedException", throwable);
    }
}
