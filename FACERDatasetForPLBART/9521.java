    /**
     * Method that returns the full path of the file system object.
     *
     * @return String The full path of the file system object
     */
    public String getFullPath() {
        if (FileHelper.isRootDirectory(this)) {
            return FileHelper.ROOT_DIRECTORY;
        } else if (FileHelper.isParentRootDirectory(this)) {
            if (this.mParent == null) {
                return FileHelper.ROOT_DIRECTORY + this.mName;
            }
            return this.mParent + this.mName;
        }
        return this.mParent + File.separator + this.mName;
    }

