    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void updateMediaMetadata() {
        MediaMetadata.Builder metadataBuilder = new MediaMetadata.Builder();
        metadataBuilder.putString(MediaMetadata.METADATA_KEY_TITLE, getTrackName());
        metadataBuilder.putString(MediaMetadata.METADATA_KEY_ARTIST, getArtistName());
        metadataBuilder.putString(MediaMetadata.METADATA_KEY_GENRE, getGenreName());
        metadataBuilder.putString(MediaMetadata.METADATA_KEY_ALBUM, getAlbumName());

        metadataBuilder.putBitmap(MediaMetadata.METADATA_KEY_ART,
                BitmapFactory.decodeResource(getResources(), R.drawable.app_icon));
        // TODO set small icon

        mSession.setMetadata(metadataBuilder.build());
    }

