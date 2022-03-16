    /**
     * Set the color this view should show.
     * @param color The color that should be selected.
     * @param callback If you want to get a callback to
     * your OnColorChangedListener.
     */
    public void setColor(int color, boolean callback) {

        int alpha = Color.alpha(color);
        int red = Color.red(color);
        int blue = Color.blue(color);
        int green = Color.green(color);

        float[] hsv = new float[3];

        Color.RGBToHSV(red, green, blue, hsv);

        mAlpha = alpha;
        mHue = hsv[0];
        mSat = hsv[1];
        mVal = hsv[2];

        if (callback && mListener != null) {
            mListener.onColorChanged(Color.HSVToColor(mAlpha, new float[]{mHue, mSat, mVal}));
        }

        invalidate();
    }

