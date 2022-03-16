    /**
     * Callback method for album art loading.
     */
	@Override
	public void albumArtLoaded() {
		coverArt.setImageBitmap(mSongHelper.getAlbumArt());
	}

