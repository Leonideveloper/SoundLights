package com.gmail.leonidandand.soundlights.mvc.controller;

/**
 * Created by Leonid on 12.07.13.
 */
public interface SoundLightsController {

    void onStart();

    void onStop();

    void onDestroy();

    void onPrevious();

    void onNext();
}
