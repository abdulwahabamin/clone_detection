    @Override
    public long duration() {
        if (mPlayers[mCurrentPlayer].isInitialized()) {
            return mPlayers[mCurrentPlayer].duration();
        }
        return -1;
    }

