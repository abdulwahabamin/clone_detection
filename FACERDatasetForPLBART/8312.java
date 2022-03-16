    private void updateAccessModeStatus() {
        // If device is not rooted, or is a restricted user, this setting cannot be changed
        final Context context = getActivity();
        boolean restrictedAccess = AndroidHelper.isSecondaryUser(context) &&
                FileManagerApplication.isRestrictSecondaryUsersAccess(context);
        this.mAccessMode.setEnabled(FileManagerApplication.hasShellCommands() && !restrictedAccess);
        if (!FileManagerApplication.hasShellCommands() ||
                !FileManagerApplication.isDeviceRooted()) {
            PreferenceCategory category = (PreferenceCategory) findPreference(
                    "general_advanced_settings");
            category.removePreference(mAccessMode);
        }
    }

