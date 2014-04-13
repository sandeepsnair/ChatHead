package com.vikytech.chatHead.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;
import com.vikytech.chatHead.R;
import com.vikytech.chatHead.Services.ChatHeadService;


public class HomeActivity extends Activity {

    private ToggleButton toggleChatHeadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        toggleChatHeadButton = (ToggleButton) findViewById(R.id.toggleChatHead);
    }

    public void toggleChatHead(View view) {
        if (toggleChatHeadButton.getText().equals("Turn Off Chat Head"))
            startService(new Intent(this, ChatHeadService.class));
        else
            stopService(new Intent(this, ChatHeadService.class));
    }
}

