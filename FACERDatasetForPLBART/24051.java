    @Override
    public long position() {
        if (mPlayers[mCurrentPlayer].isInitialized()) {
            return mPlayers[mCurrentPlayer].currentPosition();
        }
        return -1;
    }

