    /**
     * Set if the user is allowed to adjust the alpha panel. Default is false.
     * If it is set to false no alpha will be set.
     * @param visible
     */
    public void setAlphaSliderVisible(boolean visible) {

        if (mShowAlphaPanel != visible) {
            mShowAlphaPanel = visible;

            /*
             * Reset all shader to force a recreation.
             * Otherwise they will not look right after
             * the size of the view has changed.
             */
            mValShader = null;
            mSatShader = null;
            mHueShader = null;
            mAlphaShader = null;;

            requestLayout();
        }

    }

