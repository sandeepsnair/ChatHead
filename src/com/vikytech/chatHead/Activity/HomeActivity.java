package com.vikytech.chatHead.Activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;
import com.vikytech.chatHead.R;
import com.vikytech.chatHead.Services.ChatHeadService;

import static android.app.ActivityManager.RunningServiceInfo;

public class HomeActivity extends Activity {

    private ToggleButton toggleChatHeadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        toggleChatHeadButton = (ToggleButton) findViewById(R.id.toggleChatHead);
        if (isServiceEnabled()) {
            toggleChatHeadButton.setChecked(true);
        }
    }

    public void toggleChatHead(View view) {
        if (toggleChatHeadButton.getText().equals("Turn Off Chat Head")) {
            startService(new Intent(this, ChatHeadService.class));
            finish();
        } else
            stopService(new Intent(this, ChatHeadService.class));
    }

    private boolean isServiceEnabled() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (RunningServiceInfo serviceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (ChatHeadService.class.getName().equals(serviceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}

