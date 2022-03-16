    @Override
    public List<MediaBrowserCompat.MediaItem> getItemsBySearchQuery(@NonNull String query) {
        ArrayList<MediaBrowserCompat.MediaItem> mediaItems = new ArrayList<>();
        for (MediaMetadataCompat metadata : getSongs()) {
            if (metadata
                    .getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE)
                    .toLowerCase()
                    .replaceAll("\\s","")
                    .contains(query)
                    ) {
                mediaItems.add(
                        createSearchMediaItem(
                                metadata,
                                MediaIdHelper.MEDIA_ID_ALL_SONGS)
                );
            }
        }

        for (MediaMetadataCompat metadata : getAlbums()) {
            if (metadata
                    .getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE)
                    .toLowerCase()
                    .replaceAll("\\s","")
                    .contains(query)
                    ) {
                mediaItems.add(
                        createSearchMediaItem(
                                metadata,
                                MediaIdHelper.MEDIA_ID_ALBUMS)
                );
            }
        }

        for (MediaMetadataCompat metadata : getArtists()) {
            if (metadata
                    .getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE)
                    .toLowerCase()
                    .replaceAll("\\s","")
                    .contains(query)
                    ) {
                mediaItems.add(
                        createSearchMediaItem(
                                metadata,
                                MediaIdHelper.MEDIA_ID_ARTISTS)
                );
            }
        }
        return mediaItems;
    }

