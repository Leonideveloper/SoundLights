package com.gmail.leonidandand.soundlights.mvc.model;

import android.content.Context;
import android.content.res.TypedArray;

import com.gmail.leonidandand.soundlights.R;
import com.gmail.leonidandand.soundlights.mvc.model.randomizers.BackgroundModel;
import com.gmail.leonidandand.soundlights.mvc.view.SoundLightsView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Leonid on 12.07.13.
 */
public class BackgroundModelImpl implements BackgroundModel {

    private static final int[] backgroundResourcesIds = new int[] {
        R.drawable.thais1, R.drawable.thais2, R.drawable.thais3, R.drawable.thais4
    };

    private final SoundLightsView view;
    private int currentIdIndex;

    public BackgroundModelImpl(SoundLightsView view, Context context) {
        this.view = view;
        currentIdIndex = 0;
        changeViewBackground();
    }

    private void changeViewBackground() {
        view.setBackgroundById(backgroundResourcesIds[currentIdIndex]);
    }

    @Override
    public void toPreviousBackground() {
        currentIdIndex = previousIdIndex();
        changeViewBackground();
    }

    private int previousIdIndex() {
        return currentIdIndex > 0
                    ? (currentIdIndex - 1)
                    : (backgroundResourcesIds.length - 1);
    }

    @Override
    public void toNextBackground() {
        currentIdIndex = nextIdIndex();
        changeViewBackground();
    }

    private int nextIdIndex() {
        return currentIdIndex < backgroundResourcesIds.length - 1
                    ? (currentIdIndex + 1)
                    : 0;
    }
}
