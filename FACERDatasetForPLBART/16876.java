    protected void showPlaybackControls() {
        FireLog.d(TAG, "(++) showPlaybackControls");
        getSupportFragmentManager()
                .beginTransaction()
                .show(controlsFragment)
                .commitAllowingStateLoss();
    }

