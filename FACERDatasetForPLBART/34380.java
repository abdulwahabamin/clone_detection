        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            switch (key) {
                case Constants.KEY_PREF_WIDGET_THEME:
                    Intent intent = new Intent(Constants.ACTION_APPWIDGET_THEME_CHANGED);
                    getActivity().sendBroadcast(intent);
                    break;
                case Constants.KEY_PREF_WIDGET_UPDATE_PERIOD:
                    Intent intent1 = new Intent(Constants.ACTION_APPWIDGET_UPDATE_PERIOD_CHANGED);
                    getActivity().sendBroadcast(intent1);
                    setSummary();
                    break;
                case Constants.KEY_PREF_WIDGET_UPDATE_LOCATION:
                    int fineLocationPermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
                    if (fineLocationPermission != PackageManager.PERMISSION_GRANTED) {
                        Snackbar.make(getActivity().findViewById(android.R.id.content), R.string.permission_location_need, Snackbar.LENGTH_SHORT).show();
                        CheckBoxPreference updateLocation = (CheckBoxPreference) findPreference(key);
                        updateLocation.setChecked(false);
                    }
                    break;
            }
        }

