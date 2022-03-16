    private void closeInitialGuideAndCheckPermission() {
        permissionsAndSettingsRequested = false;
        SharedPreferences.Editor preferences = PreferenceManager.getDefaultSharedPreferences(this).edit();
        preferences.putInt(Constants.APP_INITIAL_GUIDE_VERSION, 4);
        preferences.apply();
        initialGuideCompleted = true;
        checkPermissionsSettingsAndShowAlert();
        updateCurrentLocationAndButtonVisibility();
    }

