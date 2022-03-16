    /**
     * Sets the width and height of the TextView containing the indicatortext. Default is WRAP_CONTENT, WRAP_CONTENT.
     * <p/>
     *
     * @param widthDP  width in DP
     * @param heightDP height in DP
     */
    public void setSize(final int widthDP, final int heightDP) {
        final float density = getResources().getDisplayMetrics().density;
        scrollIndicatorTextView.getLayoutParams().width = (int) (widthDP * density);
        scrollIndicatorTextView.getLayoutParams().height = (int) (heightDP * density);
    }

