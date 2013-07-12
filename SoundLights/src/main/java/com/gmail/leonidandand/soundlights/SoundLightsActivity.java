package com.gmail.leonidandand.soundlights;

import android.os.Bundle;
import android.app.Activity;

import com.gmail.leonidandand.soundlights.mvc.controller.SoundLightsController;
import com.gmail.leonidandand.soundlights.mvc.controller.SoundLightsControllerImpl;

public class SoundLightsActivity extends Activity {

    private SoundLightsController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new SoundLightsControllerImpl(this);
    }

    @Override
    protected void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }


}
