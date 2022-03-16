    private boolean moveTrackersIfNeeded(MotionEvent event) {

        if (mStartTouchPoint == null) return false;

        boolean update = false;

        int startX = mStartTouchPoint.x;
        int startY = mStartTouchPoint.y;


        if (mHueRect.contains(startX, startY)) {
            mLastTouchedPanel = PANEL_HUE;

            mHue = pointToHue(event.getY());

            update = true;
        }
        else if (mSatValRect.contains(startX, startY)) {

            mLastTouchedPanel = PANEL_SAT_VAL;

            float[] result = pointToSatVal(event.getX(), event.getY());

            mSat = result[0];
            mVal = result[1];

            update = true;
        }
        else if (mAlphaRect != null && mAlphaRect.contains(startX, startY)) {

            mLastTouchedPanel = PANEL_ALPHA;

            mAlpha = pointToAlpha((int)event.getX());

            update = true;
        }


        return update;
    }

