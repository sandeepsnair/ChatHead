package com.vikytech.chatHead.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.vikytech.chatHead.Services.ChatHeadService;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, ChatHeadService.class));
    }
}

