    /**
     * Get the current color this view is showing.
     * @return the current color.
     */
    public int getColor() {
        return Color.HSVToColor(mAlpha, new float[]{mHue,mSat,mVal});
    }

