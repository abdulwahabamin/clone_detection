	/**
	 * Moves the specified cursor to the specified index and populates this 
	 * helper object with new song data.
	 * 
	 * @param context Context used to get a new Common object.
	 * @param index The index of the song.
     * @param albumArtTransformer The transformer to apply to the album art bitmap;
	 */
	public void populateSongData(Context context, int index, Transformation albumArtTransformer) {
		
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

            mApp.getPicasso()
                .load(getAlbumArtPath())
                .transform(albumArtTransformer)
                .into(imageLoadingTarget);

		}

	}

