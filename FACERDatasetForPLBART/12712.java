    /**
     * Method that checks if the .nomedia file is present
     *
     * @return boolean If the .nomedia file is present
     */
    private boolean isNoMediaFilePresent() {
        final File nomedia = FileHelper.getNoMediaFile(this.mFso);
        return nomedia.exists();
    }

