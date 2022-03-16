    private void fling(int velocity) {
        final int sx = getScrollX();
        final int sy = getScrollY();

        mScroller.fling(sx, sy, -velocity, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, sy, sy);
        mFlinging = (velocity > 0) ? FLINGING_LEFT : FLINGING_RIGHT;

        setScrollState(SCROLL_STATE_SETTLING);
    }

