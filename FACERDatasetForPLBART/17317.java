    @SuppressWarnings("WeakerAccess")
    public List<MediaBrowserCompat.MediaItem> getChildren(@NonNull String mediaId) {
        Log.d(TAG, "getChildren:called mediaId="+mediaId);

        List<MediaBrowserCompat.MediaItem> mediaItems = new ArrayList<>();

        if (!MediaIdHelper.isBrowseable(mediaId)) {
            return mediaItems;
        }

        if (MediaIdHelper.MEDIA_ID_PLAYLISTS.equals(mediaId)) {// all playlists
            for (MediaMetadataCompat metadata : getPlaylists()) {
                mediaItems.add(createBrowsableMediaItemForPlaylist(metadata));
            }
        } else if (mediaId.startsWith(MediaIdHelper.MEDIA_ID_PLAYLISTS)) { // songs in one playlist
            String playlistKey = MediaIdHelper.getHierarchy(mediaId)[1];

            for (MediaMetadataCompat metadata : getMusicsByPlaylistKey(playlistKey)) {
                mediaItems.add(createMediaItem(metadata, playlistKey));
            }
        }

        return mediaItems;
    }

