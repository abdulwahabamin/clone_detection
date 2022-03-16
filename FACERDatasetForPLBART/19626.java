        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            boolean value = (Boolean) newValue;
            mApp.getSharedPreferences().edit().putBoolean(Common.SHOW_LOCKSCREEN_CONTROLS, value).commit();
            ((CheckBoxPreference) preference).setChecked(value);
            return false;
        }

