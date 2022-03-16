    /**
     * Fill the object from the parcel information.
     *
     * @param in The parcel information to recreate the object
     */
    private void readFromParcel(Parcel in) {
        // - 0
        this.mId = in.readInt();
        // - 1
        int hasCurrentDir = in.readInt();
        if (hasCurrentDir == 1) {
            this.mCurrentDir = in.readString();
        }
        // - 2
        this.mChRooted = (in.readInt() == 1);
        // - 3
        int hasSelectedFiles = in.readInt();
        if (hasSelectedFiles == 1) {
            List<FileSystemObject> selectedFiles = new ArrayList<FileSystemObject>();
            in.readList(selectedFiles, NavigationViewInfoParcelable.class.getClassLoader());
            this.mSelectedFiles = new ArrayList<FileSystemObject>(selectedFiles);
        }
        // - 4
        int hasFiles = in.readInt();
        if (hasFiles == 1) {
            List<FileSystemObject> files = new ArrayList<FileSystemObject>();
            in.readList(files, NavigationViewInfoParcelable.class.getClassLoader());
            this.mFiles = new ArrayList<FileSystemObject>(files);
        }

        // - 5
        int hasFirstVisible = in.readInt();
        if (hasFirstVisible == 1) {
            Serializable readSerializable = in.readSerializable();
            if (readSerializable instanceof FileSystemObject) {
                this.mFirstVisible = (FileSystemObject) readSerializable;
            }
        }
    }

