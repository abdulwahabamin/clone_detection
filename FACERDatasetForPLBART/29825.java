        @Override
        public boolean onPreferenceChange(Preference preference, Object o) {
            switch (preference.getKey()) {
                case Constants.PREF_DISPLAY_LANGUAGE:
                    new MaterialDialog.Builder(getActivity())
                            .title(getString(R.string.restart_app))
                            .content(getString(R.string.restart_app_content))
                            .positiveText(getString(android.R.string.ok))
                            .build()
                            .show();
                    break;
            }
            return true;
        }

