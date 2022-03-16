    private void displayMetadata(MediaMetadataCompat metadata) {
        if (metadata == null) {
            return;
        }
        mMvpView.displaySong(
                metadata.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE),
                metadata.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE),
                getFormattedDuration(
                        metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION)),
                metadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI));
        mMvpView.updateDuration(
                metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
    }

