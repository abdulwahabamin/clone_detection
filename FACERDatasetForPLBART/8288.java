    private static boolean isDirectoryPickIntent(Intent intent) {
        if (INTENT_FOLDER_SELECT.equals(intent.getAction())) {
            return true;
        }

        if (Intent.ACTION_PICK.equals(intent.getAction()) && intent.getData() != null) {
            String scheme = intent.getData().getScheme();
            if (FileHelper.FOLDER_URI_SCHEME.equals(scheme)
                    || FileHelper.DIRECTORY_URI_SCHEME.equals(scheme)) {
                return true;
            }
        }

        return false;
    }

