    @Override
    protected void onResume() {
        super.onResume();

        mHandler.postDelayed(callChangeUI, 500);
        mAdView.resume();

        mTracker.setScreenName("mainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

