    /**
     * {@link PlayPauseButton#mPlayed} γγ»γγγ?γ
     *
     * @param played ηΆζ³?
     */
    public void setPlayed(boolean played) {
        if (mPlayed != played) {
            mPlayed = played;
            invalidate();
        }
    }

