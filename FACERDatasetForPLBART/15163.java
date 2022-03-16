    public static void deleteDiskCache(Context context) throws IOException {
    	final File dir = context.getExternalCacheDir();
        final File[] files = dir.listFiles();
        for (final File file : files) {
            if (!file.delete()) {
                throw new IOException("failed to delete file: " + file);
            }
        }
    }

