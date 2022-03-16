    private void updateShuffleMode(boolean enabled) {
        if (enabled) {
            mMvpView.setShuffleModeEnabled();
        } else {
            mMvpView.setShuffleModeDisabled();
        }
    }

