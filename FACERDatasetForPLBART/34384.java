        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_about);

            mPackageManager = getActivity().getPackageManager();
            findPreference(Constants.KEY_PREF_ABOUT_VERSION).setSummary(getVersionName());
            findPreference(Constants.KEY_PREF_ABOUT_F_DROID).setIntent(fDroidIntent());
            findPreference(Constants.KEY_PREF_ABOUT_GOOGLE_PLAY).setIntent(googlePlayIntent());
        }

