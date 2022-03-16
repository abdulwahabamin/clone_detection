        @Override
        public boolean onPreferenceClick(Preference preference) {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            SettingsMusicFoldersDialog foldersDialog = new SettingsMusicFoldersDialog();
            foldersDialog.setArguments(bundle);
            foldersDialog.show(ft, "foldersDialog");

            return false;
        }

