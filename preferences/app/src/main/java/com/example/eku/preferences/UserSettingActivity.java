package com.example.eku.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by DELL on 24-02-2015.
 */
public class UserSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_setting);
    }
}
