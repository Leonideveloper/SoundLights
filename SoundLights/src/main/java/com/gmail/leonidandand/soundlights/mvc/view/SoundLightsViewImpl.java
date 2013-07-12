package com.gmail.leonidandand.soundlights.mvc.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.gmail.leonidandand.soundlights.R;
import com.gmail.leonidandand.soundlights.custom_views.ColorMatrixView;
import com.gmail.leonidandand.soundlights.mvc.controller.SoundLightsController;
import com.gmail.leonidandand.soundlights.utils.Dimension;
import com.gmail.leonidandand.soundlights.utils.Matrix;

/**
 * Created by Leonid on 12.07.13.
 */
public class SoundLightsViewImpl implements SoundLightsView {

    private final ColorMatrixView colorMatrixView;
    private final ImageButton startButton;
    private final ImageButton stopButton;

    private final SoundLightsController controller;
    private final ImageButton prevButton;
    private final ImageButton nextButton;
    private final RelativeLayout rootLayout;

    public SoundLightsViewImpl(Activity activity, SoundLightsController controller) {
        activity.setContentView(R.layout.soundlights_activity);
        this.controller = controller;
        colorMatrixView = (ColorMatrixView) activity.findViewById(R.id.colorMatrixView);
        startButton = (ImageButton) activity.findViewById(R.id.startButton);
        stopButton = (ImageButton) activity.findViewById(R.id.stopButton);
        prevButton = (ImageButton) activity.findViewById(R.id.prevButton);
        nextButton = (ImageButton) activity.findViewById(R.id.nextButton);
        rootLayout = (RelativeLayout) activity.findViewById(R.id.rootLayout);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundLightsViewImpl.this.controller.onStart();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundLightsViewImpl.this.controller.onStop();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundLightsViewImpl.this.controller.onPrevious();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundLightsViewImpl.this.controller.onNext();
            }
        });
    }

    @Override
    public void setVisibleStartButton() {
        startButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void setInvisibleStartButton() {
        startButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setVisibleStopButton() {
        stopButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void setInvisibleStopButton() {
        stopButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setColor(Matrix.Position pos, int color) {
        colorMatrixView.setColor(pos, color);
    }

    @Override
    public Dimension getColorMatrixDimension() {
        return colorMatrixView.getDimension();
    }

    @Override
    public void setBackgroundById(int id) {
        rootLayout.setBackgroundResource(id);
    }
}
