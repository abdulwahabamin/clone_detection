    public static boolean checkRestrictSecondaryUsersAccess(Context context, boolean isChroot) {
        if (!AndroidHelper.isSecondaryUser(context)) {
            return true;
        }
        boolean needChroot = !isChroot && isRestrictSecondaryUsersAccess(context);
        if (!needChroot) {
            return true;
        }

        try {
            Preferences.savePreference(
                    FileManagerSettings.SETTINGS_ACCESS_MODE, AccessMode.SAFE, true);
        } catch (Throwable ex) {
            Log.w(TAG, "can't save console preference", ex); //$NON-NLS-1$
        }
        ConsoleBuilder.changeToNonPrivilegedConsole(context);

        // Notify the change
        Intent intent = new Intent(FileManagerSettings.INTENT_SETTING_CHANGED);
        intent.putExtra(FileManagerSettings.EXTRA_SETTING_CHANGED_KEY,
                FileManagerSettings.SETTINGS_ACCESS_MODE.getId());
        context.sendBroadcast(intent);
        return false;
    }

