    @Override
    public void onResume() {
        super.onResume();
        checkServiceRunning();
        mPlayPauseBackground.setBackgroundResource(UIElementsHelper.getShadowedCircle(mContext));
        mPlayPauseButton.setId(R.drawable.pause_light);

    }

