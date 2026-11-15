package rkr.simplekeyboard.inputmethod.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public final class MainKeyboardView extends KeyboardView {
    public MainKeyboardView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public MainKeyboardView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setKeyboardActionListener(final KeyboardActionListener listener) {
        // no-op for compatibility with the current keyboard code path
    }

    public void startDoubleTapShiftKeyTimer() {
        // no-op for compatibility with the current keyboard code path
    }

    public void cancelDoubleTapShiftKeyTimer() {
        // no-op for compatibility with the current keyboard code path
    }

    public boolean isInDoubleTapShiftKeyTimeout() {
        return false;
    }

    public void startDisplayLanguageOnSpacebar(final boolean subtypeChanged,
            final int languageOnSpacebarFormatType) {
        // no-op for compatibility with the current keyboard code path
    }

    public void cancelAllOngoingEvents() {
        // no-op for compatibility with the current keyboard code path
    }

    public void closing() {
        // no-op for compatibility with the current keyboard code path
    }

    public void onHideWindow() {
        // no-op for compatibility with the current keyboard code path
    }

    public boolean isShowingMoreKeysPanel() {
        return false;
    }

    public boolean isInDraggingFinger() {
        return false;
    }

    public boolean isInCursorMove() {
        return false;
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
