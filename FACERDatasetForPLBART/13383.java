    /**
     * Method that create a new temporary filename
     *
     * @param external If the file should be created in the external or the internal cache dir
     */
    public static synchronized File createTempFilename(Context context, boolean external) {
        File tempDirectory = external ? context.getExternalCacheDir() : context.getCacheDir();
        File tempFile;
        do {
            UUID uuid = UUID.randomUUID();
            tempFile = new File(tempDirectory, uuid.toString());
        } while (tempFile.exists());
        return tempFile;
    }

