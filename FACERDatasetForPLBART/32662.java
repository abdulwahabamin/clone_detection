        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                                             Preference preference) {
            if (preference.equals(findPreference(Constants.KEY_PREF_ABOUT_OPEN_SOURCE_LICENSES))) {
                LicensesDialogFragment licensesDialog = LicensesDialogFragment.newInstance();
                licensesDialog.show(getFragmentManager(), "LicensesDialog");
            }
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }

