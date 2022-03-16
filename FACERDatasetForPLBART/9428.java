    public static boolean isRestrictSecondaryUsersAccess(Context context) {
        String value = Preferences.getWorldReadableProperties(
                context, FileManagerSettings.SETTINGS_RESTRICT_SECONDARY_USERS_ACCESS.getId());
        if (value == null) {
            value = String.valueOf(FileManagerSettings.SETTINGS_RESTRICT_SECONDARY_USERS_ACCESS.
                    getDefaultValue());
        }
        return Boolean.parseBoolean(value);
    }

