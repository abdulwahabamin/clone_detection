    /**
     * Method that clear the cache
     *
     * @param ctx The current context
     */
    private void clearCache(Context ctx) {
        File filesDir = ctx.getExternalFilesDir(null);
        if (filesDir == null) {
            return;
        }

        File[] cacheFiles = filesDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                return filename.startsWith(mStorageName)
                        && filename.endsWith(".tmp");
            }
        });
        for (File cacheFile : cacheFiles) {
            cacheFile.delete();
        }
    }

