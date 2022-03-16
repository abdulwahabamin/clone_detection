    @Override
    public void onPause() {
        super.onPause();
        if (isFinishing())
            mApp.setNowPlayingActivity(null);

    }

