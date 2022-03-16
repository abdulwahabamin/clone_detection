    private void checkAndShowInitialGuide() {
        int initialGuideVersion = PreferenceManager.getDefaultSharedPreferences(getBaseContext())
                .getInt(Constants.APP_INITIAL_GUIDE_VERSION, 0);
        if (initialGuideVersion > 0) {
            initialGuideCompleted = true;
            if (initialGuideVersion < 3) {
                checkBatteryOptimization();
            }
            showVoiceAndSourcesDisclaimer();
            return;
        }
        if (initialGuidePage > 0) {
            return;
        }
        initialGuidePage = 1;
        showInitialGuidePage(initialGuidePage);
    }

