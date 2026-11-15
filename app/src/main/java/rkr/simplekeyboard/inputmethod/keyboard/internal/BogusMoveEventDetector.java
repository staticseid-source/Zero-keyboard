package rkr.simplekeyboard.inputmethod.keyboard.internal;

import android.content.res.Resources;

public final class BogusMoveEventDetector {
    private static boolean sNeedsProximateBogusDownMoveUpEventHack;

    public static void init(final Resources res) {
        sNeedsProximateBogusDownMoveUpEventHack = false;
    }

    private int mAccumulatedDistanceThreshold;
    int mAccumulatedDistanceFromDownKey;
    private int mActualDownX;
    private int mActualDownY;

    public void setKeyboardGeometry(final int keyPaddedWidth, final int keyPaddedHeight) {
        mAccumulatedDistanceThreshold = 0;
    }

    public void onActualDownEvent(final int x, final int y) {
        mActualDownX = x;
        mActualDownY = y;
    }

    public void onDownKey() {
        mAccumulatedDistanceFromDownKey = 0;
    }

    public void onMoveKey(final int distance) {
        mAccumulatedDistanceFromDownKey += distance;
    }

    public boolean hasTraveledLongDistance(final int x, final int y) {
        if (!sNeedsProximateBogusDownMoveUpEventHack) {
            return false;
        }
        if (mAccumulatedDistanceThreshold <= 0) {
            return false;
        }
        final int dx = Math.abs(x - mActualDownX);
        final int dy = Math.abs(y - mActualDownY);
        return dx >= dy && mAccumulatedDistanceFromDownKey >= mAccumulatedDistanceThreshold;
    }

    public int getAccumulatedDistanceFromDownKey() {
        return mAccumulatedDistanceFromDownKey;
    }
}
