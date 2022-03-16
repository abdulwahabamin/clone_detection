    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void updateRemoteControlClient(final String what) {
        //Legacy for ICS
        if (mRemoteControlClient != null) {
            int playState = mIsSupposedToBePlaying
                    ? RemoteControlClient.PLAYSTATE_PLAYING
                    : RemoteControlClient.PLAYSTATE_PAUSED;
            if (what.equals(META_CHANGED) || what.equals(QUEUE_CHANGED)) {
                Bitmap albumArt = null;
                if (mShowAlbumArtOnLockscreen) {
                    albumArt = ImageLoader.getInstance().loadImageSync(TimberUtils.getAlbumArtUri(getAlbumId()).toString());
                    if (albumArt != null) {

                        Bitmap.Config config = albumArt.getConfig();
                        if (config == null) {
                            config = Bitmap.Config.ARGB_8888;
                        }
                        albumArt = albumArt.copy(config, false);
                    }
                }

                RemoteControlClient.MetadataEditor editor = mRemoteControlClient.editMetadata(true);
                editor.putString(MediaMetadataRetriever.METADATA_KEY_ALBUM, getAlbumName());
                editor.putString(MediaMetadataRetriever.METADATA_KEY_ARTIST, getArtistName());
                editor.putString(MediaMetadataRetriever.METADATA_KEY_TITLE, getTrackName());
                editor.putLong(MediaMetadataRetriever.METADATA_KEY_DURATION, duration());
                editor.putBitmap(MediaMetadataEditor.BITMAP_KEY_ARTWORK, albumArt);
                editor.apply();

            }
            mRemoteControlClient.setPlaybackState(playState);
        }
    }

