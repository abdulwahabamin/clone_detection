    /**
     * Notify the change-receivers that something has changed. The intent that
     * is sent contains the following data for the currently playing track: "id"
     * - Integer: the database row ID "artist" - String: the name of the artist
     * "album" - String: the name of the album "track" - String: the name of the
     * track The intent has an action that is one of
     * "com.spacecaker.butter.metachanged" "com.spacecaker.butter.queuechanged",
     * "com.spacecaker.butter.playbackcomplete" "com.spacecaker.butter.playstatechanged"
     * respectively indicating that a new track has started playing, that the
     * playback queue has changed, that playback has stopped because the last
     * file in the list has been played, or that the play-state changed
     * (paused/resumed).
     */
    public void notifyChange(String what) {

        Intent i = new Intent(what);
        i.putExtra("id", Long.valueOf(getAudioId()));
        i.putExtra("artist", getArtistName());
        i.putExtra("album", getAlbumName());
        i.putExtra("track", getTrackName());
        i.putExtra("playing", mIsSupposedToBePlaying);
        i.putExtra("isfavorite", isFavorite());
        sendStickyBroadcast(i);

        i = new Intent(i);
        i.setAction(what.replace(APOLLO_PACKAGE_NAME, MUSIC_PACKAGE_NAME));
        sendStickyBroadcast(i);

        if (what.equals(PLAYSTATE_CHANGED)) {
            mRemoteControlClient
                    .setPlaybackState(mIsSupposedToBePlaying ? RemoteControlClient.PLAYSTATE_PLAYING
                            : RemoteControlClient.PLAYSTATE_PAUSED);
        } else if (what.equals(META_CHANGED)) {
            RemoteControlClient.MetadataEditor ed = mRemoteControlClient.editMetadata(true);
            ed.putString(MediaMetadataRetriever.METADATA_KEY_TITLE, getTrackName());
            ed.putString(MediaMetadataRetriever.METADATA_KEY_ALBUM, getAlbumName());
            ed.putString(MediaMetadataRetriever.METADATA_KEY_ARTIST, getArtistName());
            ed.putLong(MediaMetadataRetriever.METADATA_KEY_DURATION, duration());
            Bitmap b = getAlbumBitmap();
            if (b != null) {
                ed.putBitmap(MetadataEditor.BITMAP_KEY_ARTWORK, b);
            }
            ed.apply();
        }

        if (what.equals(QUEUE_CHANGED)) {
            saveQueue(true);
        } else {
            saveQueue(false);
        }
        mAppWidgetProvider1x1.notifyChange(this, what);
        mAppWidgetProvider4x1.notifyChange(this, what);
        mAppWidgetProvider4x2.notifyChange(this, what);
		mAppWidgetProvider4x22.notifyChange(this, what);

    }

