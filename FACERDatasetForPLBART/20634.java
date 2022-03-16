    /**
     * Turns on fixed size for the TextView containing the indicatortext. Do not use with setSize()! This mode looks good if the indicatortext length is fixed, e.g. it's always two characters long.
     * <p/>
     *
     * @param sizeEMS number of characters in the indicatortext
     */
    public void setFixedSize(final int sizeEMS) {
        scrollIndicatorTextView.setEms(sizeEMS);
    }

