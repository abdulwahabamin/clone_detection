    protected void hidePlaybackControls() {
        FireLog.d(TAG, "(++) hidePlaybackControls");
        if (isFinishing() || isDestroyed()) {
            return;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .hide(controlsFragment)
                .commitAllowingStateLoss();
    }

