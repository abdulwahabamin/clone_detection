    private void showVoiceAndSourcesDisclaimer() {
        int initialGuideVersion = PreferenceManager.getDefaultSharedPreferences(getBaseContext())
                .getInt(Constants.APP_INITIAL_GUIDE_VERSION, 0);
        if (initialGuideVersion != 3) {
            return;
        }
        final Context localContext = getBaseContext();
        final AlertDialog.Builder settingsAlert = new AlertDialog.Builder(MainActivity.this);
        settingsAlert.setTitle(R.string.alertDialog_voice_disclaimer_title);
        settingsAlert.setMessage(R.string.alertDialog_voice_disclaimer_message);
        settingsAlert.setNeutralButton(R.string.alertDialog_battery_optimization_proceed,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor preferences = PreferenceManager.getDefaultSharedPreferences(localContext).edit();
                        preferences.putInt(Constants.APP_INITIAL_GUIDE_VERSION, 4);
                        preferences.apply();
                    }
                });
        settingsAlert.show();
    }

