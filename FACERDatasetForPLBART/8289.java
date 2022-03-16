    private static File getInitialDirectoryFromIntent(Intent intent) {
        if (!Intent.ACTION_PICK.equals(intent.getAction())) {
            return null;
        }

        if (INTENT_FOLDER_SELECT.equals(intent.getAction())) {
            return Environment.getExternalStorageDirectory();
        }

        final Uri data = intent.getData();
        if (data == null) {
            return null;
        }

        final String path = data.getPath();
        if (path == null) {
            return null;
        }

        final File file = new File(path);
        if (!file.exists() || !file.isAbsolute()) {
            return null;
        }

        if (file.isDirectory()) {
            return file;
        }
        return file.getParentFile();
    }

