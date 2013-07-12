package com.gmail.leonidandand.soundlights.mvc.model;

import android.os.Handler;

public class PeriodicallyTask {

    private boolean stopped;

    private Handler handler;
    private Runnable periodicallyRunnable;

    public void start(final Runnable runnable, final long delayInMilliseconds) {
        handler = new Handler();
        stopped = false;
        periodicallyRunnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    runnable.run();
                    if (!stopped) {
                        handler.postDelayed(periodicallyRunnable, delayInMilliseconds);
                    }
                }
            }
        };
        periodicallyRunnable.run();
    }

    public void stop() {
        synchronized (this) {
            handler.removeCallbacks(periodicallyRunnable);
            stopped = true;
        }
    }
}
