package com.gmail.leonidandand.soundlights.mvc.model;

import com.gmail.leonidandand.soundlights.mvc.model.randomizers.ColorRandomizer;
import com.gmail.leonidandand.soundlights.mvc.model.randomizers.PositionRandomizer;
import com.gmail.leonidandand.soundlights.mvc.view.SoundLightsView;
import com.gmail.leonidandand.soundlights.utils.Dimension;
import com.gmail.leonidandand.soundlights.utils.Matrix;


public class SoundLightModelImpl implements SoundLightsModel, Runnable {

    private static final long DELAY_IN_MILLISECONDS = 6;

    private final SoundLightsView view;
    private final PositionRandomizer positionRandomizer;
    private final ColorRandomizer colorRandomizer;
    private PeriodicallyTask singlePeriodicallyTask;

    public SoundLightModelImpl(SoundLightsView view) {
        this.view = view;
        positionRandomizer = new PositionRandomizer();
        colorRandomizer = new ColorRandomizer();
    }

    @Override
    public void startSoundLights() {
        singlePeriodicallyTask = new PeriodicallyTask();
        singlePeriodicallyTask.start(this, DELAY_IN_MILLISECONDS);
    }

    @Override
    public void stopSoundLights() {
        if (singlePeriodicallyTask != null) {
            singlePeriodicallyTask.stop();
            singlePeriodicallyTask = null;
        }
    }

    @Override
    public void run() {
        randomUpdateColor();
    }

    private synchronized void randomUpdateColor() {
        Dimension dim = view.getColorMatrixDimension();
        Matrix.Position randomPosition = positionRandomizer.randomPosition(dim);
        int randomColor = colorRandomizer.randomColor();
        view.setColor(randomPosition, randomColor);
    }
}
