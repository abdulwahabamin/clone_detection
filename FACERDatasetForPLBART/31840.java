    private void checkBatteryOptimization() {
        int initialGuideVersion = PreferenceManager.getDefaultSharedPreferences(getBaseContext())
                .getInt(Constants.APP_INITIAL_GUIDE_VERSION, 0);
        if (initialGuideVersion < 4) {
            SharedPreferences.Editor preferences = PreferenceManager.getDefaultSharedPreferences(this).edit();
            preferences.putInt(Constants.APP_INITIAL_GUIDE_VERSION, 4);
            preferences.apply();
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        AlertDialog.Builder settingsAlert = new AlertDialog.Builder(MainActivity.this);
        settingsAlert.setTitle(R.string.alertDialog_battery_optimization_title);
        settingsAlert.setMessage(R.string.alertDialog_battery_optimization_message);
        settingsAlert.setPositiveButton(R.string.alertDialog_battery_optimization_proceed,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                                return;
                            }
                            Intent intent = new Intent();
                            String packageName = getPackageName();
                            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                            if (pm.isIgnoringBatteryOptimizations(packageName))
                                intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                            else {
                                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                                intent.setData(Uri.parse("package:" + packageName));
                            }
                            startActivity(intent);
                        }
                    });
        settingsAlert.setNegativeButton(R.string.alertDialog_battery_optimization_cancel,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        permissionsAndSettingsRequested = false;
                        dialog.cancel();
                    }
                });
        settingsAlert.show();
    }

