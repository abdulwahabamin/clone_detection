    /**
     * Initializes the mini player above the current queue.
     */
    private void initMiniPlayer() {
        mMiniPlayerLayout.setVisibility(View.VISIBLE);
        mMiniPlayerAlbumArt.setImageBitmap(mApp.getService().getCurrentSong().getAlbumArt());
        mTitleText.setText(mApp.getService().getCurrentSong().getTitle());
        mSubText.setText(mApp.getService().getCurrentSong().getAlbum() + " - " +
                         mApp.getService().getCurrentSong().getArtist());

    }

