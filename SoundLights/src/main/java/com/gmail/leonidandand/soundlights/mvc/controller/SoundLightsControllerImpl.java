package com.gmail.leonidandand.soundlights.mvc.controller;

import android.app.Activity;
import android.content.Context;

import com.gmail.leonidandand.soundlights.mvc.model.BackgroundModelImpl;
import com.gmail.leonidandand.soundlights.mvc.model.SoundLightModelImpl;
import com.gmail.leonidandand.soundlights.mvc.model.SoundLightsModel;
import com.gmail.leonidandand.soundlights.mvc.model.randomizers.BackgroundModel;
import com.gmail.leonidandand.soundlights.mvc.view.SoundLightsView;
import com.gmail.leonidandand.soundlights.mvc.view.SoundLightsViewImpl;

/**
 * Created by Leonid on 12.07.13.
 */
public class SoundLightsControllerImpl implements SoundLightsController {

    private final SoundLightsModel soundLightsModel;
    private final SoundLightsView view;
    private final BackgroundModel backgroundModel;

    public SoundLightsControllerImpl(Activity activity) {
        this.view = new SoundLightsViewImpl(activity, this);
        this.soundLightsModel = new SoundLightModelImpl(view);
        this.backgroundModel = new BackgroundModelImpl(view, (Context) activity);
    }

    @Override
    public void onStart() {
        view.setInvisibleStartButton();
        view.setVisibleStopButton();
        soundLightsModel.startSoundLights();
    }

    @Override
    public void onStop() {
        soundLightsModel.stopSoundLights();
        view.setVisibleStartButton();
        view.setInvisibleStopButton();
    }

    @Override
    public void onDestroy() {
        soundLightsModel.stopSoundLights();
    }

    @Override
    public void onPrevious() {
        backgroundModel.toPreviousBackground();
    }

    @Override
    public void onNext() {
        backgroundModel.toNextBackground();
    }
}
