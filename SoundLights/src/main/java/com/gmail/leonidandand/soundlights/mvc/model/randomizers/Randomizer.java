package com.gmail.leonidandand.soundlights.mvc.model.randomizers;

import java.util.Random;

/**
 * Created by Leonid on 12.07.13.
 */
public class Randomizer {

    public static int randomPositiveInt() {
        Random random = new Random(System.currentTimeMillis());
        random.setSeed(System.nanoTime());
        return Math.abs(random.nextInt());
    }
}
