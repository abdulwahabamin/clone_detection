    @Override
    public void onSlidingUpPanelSlide(float slideOffset) {
        if (slideOffset >= 0.9) {
            mMvpView.hideMiniPlayer();
        } else if (slideOffset <= 0.1) {
            mMvpView.showMiniPlayer();
        }
    }

