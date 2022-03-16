    public List<MediaBrowserCompat.MediaItem> getChildren(String mediaId) {
        FireLog.d(TAG, "(++) getChildren, mediaId=" + mediaId);
        List<MediaBrowserCompat.MediaItem> mediaItems = new ArrayList<>();

        if (mediaId.equals(MEDIA_ID_ROOT)) {
            // no item for root // root items are handled by Drawer

        } else if (mediaId.equals(MEDIA_ID_TRACKS)) {
            // fill the music List once and keep ever
            musicList.addAll(mediaList);

            for (MediaMetadataCompat metadata : getAllRetrievedMetadata()) {
                mediaItems.add(createTracksMediaItem(metadata));
            }
        } else if (mediaId.equals(MEDIA_ID_PLAYLIST) || mediaId.equals(MEDIA_ID_ALBUM)
                || mediaId.equals(MEDIA_ID_ARTIST) || mediaId.equals(MEDIA_ID_GENRE)
                || mediaId.equals(MEDIA_ID_FOLDER)) {
            String category = mediaId;
            for (MediaMetadataCompat metadata : getAllRetrievedMetadata()) {
                String subCategory = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
                mediaItems.add(createBrowsableMediaItemForSubCategory(category, subCategory, metadata));
            }
        } else if (mediaId.startsWith(MEDIA_ID_PLAYLIST) || mediaId.startsWith(MEDIA_ID_ALBUM)
                || mediaId.startsWith(MEDIA_ID_ARTIST) || mediaId.startsWith(MEDIA_ID_GENRE)
                || mediaId.startsWith(MEDIA_ID_FOLDER)) {
            String category = MediaIDHelper.getHierarchy(mediaId)[0];
            String subCategory = MediaIDHelper.getHierarchy(mediaId)[1];
            for (MediaMetadataCompat metadata : getAllRetrievedMetadata()) {
                mediaItems.add(createPlayableMediaItem(category, subCategory, metadata));
            }

        } else {
            FireLog.w(TAG, "unmatched mediaId: " + mediaId);
        }
        return mediaItems;
    }

