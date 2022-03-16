    private void updateRemoteControl() {
        mRemoteControlClient.setPlaybackState(isPlaying()
                ? RemoteControlClient.PLAYSTATE_PLAYING
                : RemoteControlClient.PLAYSTATE_PAUSED);

        RemoteControlClient.MetadataEditor metadataEditor = mRemoteControlClient.editMetadata(true);
        metadataEditor.putString(MediaMetadataRetriever.METADATA_KEY_TITLE, getTrackName());
        metadataEditor.putString(MediaMetadataRetriever.METADATA_KEY_ARTIST, getArtistName());
        metadataEditor.putString(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST, getArtistName());
        metadataEditor.putString(MediaMetadataRetriever.METADATA_KEY_GENRE, getGenreName());
        metadataEditor.apply();
    }

