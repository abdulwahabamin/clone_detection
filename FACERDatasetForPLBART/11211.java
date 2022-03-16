    /**
     * Method that Clears Cache of the adapter
     * @param fso The Selected FileSystemObject reference
     */
    public void clearCache(FileSystemObject fso) {
        if (mIconHolder != null) {
            mIconHolder.clearCacheImages(fso);
            notifyDataSetChanged();
        }
    }

