    /**
     * Clearing the selected Icon Cache
     * @param fso The Selected FileSystemObject reference
     */
    public void clearCacheImages(FileSystemObject fso) {
        final String filePath = MediaHelper.normalizeMediaPath(fso.getFullPath());
        if (filePath != null) {
            mAppIcons.remove(filePath);
        }
    }

