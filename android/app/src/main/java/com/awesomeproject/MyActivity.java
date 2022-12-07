package com.awesomeproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Context context = getApplicationContext();

        Toast.makeText( context,"Fixed up i hopey!", Toast.LENGTH_SHORT).show();

        setContentView(R.layout.panik);

        final Button button = (Button) findViewById(R.id.PANIKBUTTOn);
        button.setOnClickListener(e -> {

            Toast.makeText( context,"Fixed up i hope!", Toast.LENGTH_SHORT).show();

        });
    }

}