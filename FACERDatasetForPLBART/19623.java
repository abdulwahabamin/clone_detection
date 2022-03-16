        @Override
        public boolean onPreferenceClick(Preference preference) {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ApplicationThemeDialog appThemeDialog = new ApplicationThemeDialog();
            appThemeDialog.show(ft, "appThemeDialog");

            return false;
        }

