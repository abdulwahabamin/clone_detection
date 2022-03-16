    public void setSliderTrackerColor(int color) {
        mSliderTrackerColor = color;

        mHueTrackerPaint.setColor(mSliderTrackerColor);

        invalidate();
    }

