    /**
     * Invoked when the instance need to be saved.
     *
     * @return NavigationViewInfoParcelable The serialized info
     */
    public NavigationViewInfoParcelable onSaveState() {
        //Return the persistent the data
        NavigationViewInfoParcelable parcel = new NavigationViewInfoParcelable();
        parcel.setId(this.mId);
        parcel.setCurrentDir(this.mPreviousDir);
        parcel.setChRooted(this.mChRooted);
        parcel.setSelectedFiles(this.mAdapter.getSelectedItems());
        parcel.setFiles(this.mFiles);

        int firstVisiblePosition = mAdapterView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0 && firstVisiblePosition < mAdapter.getCount()) {
            FileSystemObject firstVisible = mAdapter
                    .getItem(firstVisiblePosition);
            parcel.setFirstVisible(firstVisible);
        }

        return parcel;
    }

