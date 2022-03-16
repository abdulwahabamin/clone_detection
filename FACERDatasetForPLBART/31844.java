    private void setNextButton(AlertDialog.Builder settingsAlert, int labelId) {
        settingsAlert.setPositiveButton(labelId,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        initialGuidePage++;
                        if (initialGuidePage > 10) {
                            initialGuideCompleted = true;
                            permissionsAndSettingsRequested = false;
                            saveInitialPreferences();
                            updateCurrentLocationAndButtonVisibility();
                            checkPermissionsSettingsAndShowAlert();
                        } else {
                            showInitialGuidePage(initialGuidePage);
                        }
                    }
                });
    }

