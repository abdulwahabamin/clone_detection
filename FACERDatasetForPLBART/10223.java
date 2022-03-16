    /**
     * Method that sets the listener for listen flinging events
     *
     * @param mOnItemFlingerListener The flinging listener
     */
    public void setOnItemFlingerListener(OnItemFlingerListener mOnItemFlingerListener) {
        this.mOnItemFlingerListener = mOnItemFlingerListener;
        if (mOnItemFlingerListener == null) {
            setLongClickable(true);
            setClickable(true);
        } else {
            // This events are trap inside this method
            setLongClickable(false);
            setClickable(false);
        }
    }

