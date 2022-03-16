    /**
     * Moves the specified cursor to the specified index and populates this
     * helper object with new song data. Note that this method only laods
     * the song's title and artist. All other fields are set to null. To
     * retrieve all song data, see populateSongData().
     *
     * @param context Context used to get a new Common object.
     * @param index The index of the song.
     */
    public void populateBasicSongData(Context context, int index) {

        mSongHelper = this;
        mApp = (Common) context.getApplicationContext();
        mIndex = index;

        if (mApp.isServiceRunning()) {
            mApp.getService().getCursor().moveToPosition(mApp.getService().getPlaybackIndecesList().get(index));

            this.setId(mApp.getService().getCursor().getString(getIdColumnIndex()));
            this.setTitle(mApp.getService().getCursor().getString(getTitleColumnIndex()));
            this.setAlbum(mApp.getService().getCursor().getString(getAlbumColumnIndex()));
            this.setArtist(mApp.getService().getCursor().getString(getArtistColumnIndex()));
            this.setAlbumArtist(mApp.getService().getCursor().getString(getAlbumArtistColumnIndex()));
            this.setGenre(determineGenreName(context));
            this.setDuration(determineDuration());

            this.setFilePath(mApp.getService().getCursor().getString(getFilePathColumnIndex()));
            this.setAlbumArtPath(determineAlbumArtPath());
            this.setSource(determineSongSource());
            this.setLocalCopyPath(determineLocalCopyPath());
            this.setSavedPosition(determineSavedPosition());

        }

    }

