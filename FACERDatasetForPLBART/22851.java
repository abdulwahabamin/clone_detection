    /**
     * Sets the child view inside a page to match the page size against.
     *
     * @param matchChildWidthResId the child id
     */
    public void setMatchChildWidth(int matchChildWidthResId) {
        if (mMatchWidthChildResId != matchChildWidthResId) {
            mMatchWidthChildResId = matchChildWidthResId;
            mNeedsMeasurePage = true;
        }
    }

