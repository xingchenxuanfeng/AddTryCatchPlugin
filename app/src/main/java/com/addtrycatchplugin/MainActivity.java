package com.addtrycatchplugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("MainActivity", "before");
        TestCrash2.crashMethod1();
        Log.e("MainActivity", "after");
    }
}
