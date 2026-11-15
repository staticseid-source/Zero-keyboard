package rkr.simplekeyboard.inputmethod.latin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class PrivateClipboard {
    private static final int MAX_ITEMS = 12;

    private final ArrayDeque<String> mItems = new ArrayDeque<>(MAX_ITEMS);

    public synchronized void add(final String text) {
        if (text == null) {
            return;
        }
        final String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return;
        }
        if (mItems.contains(trimmed)) {
            mItems.remove(trimmed);
        }
        while (mItems.size() >= MAX_ITEMS) {
            mItems.pollLast();
        }
        mItems.offerFirst(trimmed);
    }

    public synchronized String getMostRecent() {
        return mItems.peekFirst();
    }

    public synchronized List<String> getAll() {
        return new ArrayList<>(mItems);
    }

    public synchronized void clear() {
        mItems.clear();
    }
}
