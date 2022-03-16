    /**
     * {@link PlayPauseButton#mPlayed} をセット�?�る
     *
     * @param played 状�?
     */
    public void setPlayed(boolean played) {
        if (mPlayed != played) {
            mPlayed = played;
            invalidate();
        }
    }

