    @Override
    public List<MediaBrowserCompat.MediaItem> getChildren(@NonNull String mediaId) {
        Log.d(TAG, "getChildren:called mediaId="+mediaId);

        List<MediaBrowserCompat.MediaItem> mediaItems = new ArrayList<>();

        if (!MediaIdHelper.isBrowseable(mediaId)) {
            return mediaItems;
        }

        if (MediaIdHelper.MEDIA_ID_ALL_SONGS.equals(mediaId)) {// all songs list
            for (MediaMetadataCompat metadata : getSongs()) {
                mediaItems.add(
                        createMediaItem(
                                metadata,
                                MediaIdHelper.MEDIA_ID_ALL_SONGS,
                                null)
                );
            }
        } else if (MediaIdHelper.MEDIA_ID_ALBUMS.equals(mediaId)) { // all albums list
            for (MediaMetadataCompat album : getAlbums()) {
                mediaItems.add(createBrowsableMediaItemForAlbum(album));
            }
        } else if (MediaIdHelper.MEDIA_ID_ARTISTS.equals(mediaId)) { // all artists list
            for (MediaMetadataCompat artist : getArtists()) {
                mediaItems.add(createBrowsableMediaItemForArtist(artist));
            }
        } else if (mediaId.startsWith(MediaIdHelper.MEDIA_ID_ALBUMS)) { // songs of an album
            String album = MediaIdHelper.getHierarchy(mediaId)[1];
            for (MediaMetadataCompat metadata : getMusicsByAlbumKey(album)) {
                mediaItems.add(createMediaItem(metadata,
                        MediaIdHelper.MEDIA_ID_ALBUMS,
                        MusicProviderSource.CUSTOM_METADATA_KEY_ALBUM_KEY));
            }
        } else if (mediaId.startsWith(MediaIdHelper.MEDIA_ID_ARTISTS)) { // songs of an artist
            String artist = MediaIdHelper.getHierarchy(mediaId)[1];
            for (MediaMetadataCompat metadata : getMusicsByArtistKey(artist)) {
                mediaItems.add(createMediaItem(metadata,
                        MediaIdHelper.MEDIA_ID_ARTISTS,
                        MusicProviderSource.CUSTOM_METADATA_KEY_ARTIST_KEY));
            }
        } else {
            Log.w(TAG, "getChildren:skipping unmatched mediaId: "+mediaId);
        }
        return mediaItems;
    }

