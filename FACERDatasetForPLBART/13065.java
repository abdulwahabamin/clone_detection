    /**
     * Invoked when the instance need to be restored.
     *
     * @param info The serialized info
     * @return boolean If can restore
     */
    public boolean onRestoreState(NavigationViewInfoParcelable info) {
        //Restore the data
        this.mId = info.getId();
        this.mCurrentDir = info.getCurrentDir();
        this.mChRooted = info.getChRooted();
        this.mFiles = info.getFiles();
        this.mAdapter.setSelectedItems(info.getSelectedFiles());

        final FileSystemObject firstVisible = info.getFirstVisible();

        //Update the views
        refresh(firstVisible);
        return true;
    }

