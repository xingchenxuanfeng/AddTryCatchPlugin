package com.addtrycatch;

/**
 * @author xc
 * @time 19-2-28.
 */
public class Config {
    private static Config sInstance = new Config();

    public AddTryCatchExtension extension;

    public static Config getInstance() {
        return sInstance;
    }
}
