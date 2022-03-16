        @Override
        public boolean onPreferenceClick(Preference preference) {
            String key = preference.getKey();
            if (KEY_RESET_COLOR_SCHEME.compareTo(key) == 0) {
                loadDefaultColorScheme(true);
            }
            return false;
        }

