        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_powersave);
            initLocationCache();
            initWakeUpStrategy();
        }

