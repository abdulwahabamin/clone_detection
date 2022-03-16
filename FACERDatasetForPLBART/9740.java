    private static File getWorldReadablePropertiesFile(Context context) {
        String dataDir = context.getApplicationInfo().dataDir;
        if (AndroidHelper.isSecondaryUser(context)) {
            dataDir = dataDir.replace(String.valueOf(UserHandle.myUserId()),
                    String.valueOf(UserHandle.USER_OWNER));
        }
        return new File(dataDir, SHARED_PROPERTIES_FILENAME);
    }

