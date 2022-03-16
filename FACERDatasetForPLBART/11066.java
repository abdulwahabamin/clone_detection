    private static boolean isFilePickIntent(Intent intent) {
        final String action = intent.getAction();

        if (Intent.ACTION_GET_CONTENT.equals(action)) {
            return true;
        }
        if (Intent.ACTION_PICK.equals(action)) {
            final Uri data = intent.getData();
            if (data != null && FileHelper.FILE_URI_SCHEME.equals(data.getScheme())) {
                return true;
            }
        }

        return false;
    }

