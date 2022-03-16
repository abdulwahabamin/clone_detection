    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged() entry.");

        // Checks the orientation of the screen
/*
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }
*/

        setupDisplay(displayInfo);

        if ((musicSrv != null) && musicSrv.hasTrack())
            updateControls();
    }

