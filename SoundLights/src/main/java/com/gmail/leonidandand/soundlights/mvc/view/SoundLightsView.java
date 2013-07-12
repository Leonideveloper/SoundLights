package com.gmail.leonidandand.soundlights.mvc.view;

import com.gmail.leonidandand.soundlights.utils.Dimension;
import com.gmail.leonidandand.soundlights.utils.Matrix;

/**
 * Created by Leonid on 12.07.13.
 */
public interface SoundLightsView {

    void setVisibleStartButton();

    void setInvisibleStartButton();

    void setVisibleStopButton();

    void setInvisibleStopButton();

    void setColor(Matrix.Position pos, int color);

    Dimension getColorMatrixDimension();

    void setBackgroundById(int id);
}
