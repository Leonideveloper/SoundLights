package com.gmail.leonidandand.soundlights.mvc.model.randomizers;

import android.graphics.Color;

/**
 * Created by Leonid on 12.07.13.
 */
public class ColorRandomizer {

    private static final int MAX_ALPHA_COMPONENT = 45;

    public static int randomColor() {
        int alpha = Randomizer.randomPositiveInt() % MAX_ALPHA_COMPONENT;
        int red = Randomizer.randomPositiveInt() % 256;
        int green = Randomizer.randomPositiveInt() % 256;
        int blue = Randomizer.randomPositiveInt() % 256;
        return Color.argb(alpha, red, green, blue);
    }
}
