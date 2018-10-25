package com.rockin.easybox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void continue_button_clicked(View view){
        startActivity(new Intent(WelcomeActivity.this, SubmitPhoneNumberActivity.class));
    }
}
