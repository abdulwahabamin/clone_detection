    private synchronized boolean retrieveMedia(@NonNull String query) {
        boolean initialized = false;
        results.clear();
        try {
            Iterator<MediaMetadataCompat> iterator = source.searchTracks(query, limit).iterator();
            if (iterator.hasNext()) {
                results.add(new MediaItemWrapper(FireApplication.getInstance().getResources().getString(R.string.nav_menu_tracks)));
                while (iterator.hasNext()) {
                    MediaMetadataCompat metadata = iterator.next();
                    String category = MediaIDHelper.MEDIA_ID_TRACKS;
                    String subCategory = MediaIDHelper.MEDIA_ID_TRACKS_ALL;
                    results.add(new MediaItemWrapper(Category.TRACK,
                            createPlayableMediaItem(category, subCategory, metadata)));
                }
            }

            iterator = source.searchAlbums(query, limit).iterator();
            if (iterator.hasNext()) {
                results.add(new MediaItemWrapper(FireApplication.getInstance().getResources().getString(R.string.nav_menu_albums)));
                while (iterator.hasNext()) {
                    MediaMetadataCompat metadata = iterator.next();
                    String category = MediaIDHelper.MEDIA_ID_ALBUM;
                    String subCategory = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
                    results.add(new MediaItemWrapper(Category.ALBUM,
                            createBrowsableMediaItemForSubCategory(category, subCategory, metadata)));
                }
            }

            iterator = source.searchArtists(query, limit).iterator();
            if (iterator.hasNext()) {
                results.add(new MediaItemWrapper(FireApplication.getInstance().getString(R.string.nav_menu_artists)));
                while (iterator.hasNext()) {
                    MediaMetadataCompat metadata = iterator.next();
                    String category = MediaIDHelper.MEDIA_ID_ARTIST;
                    String subCategory = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
                    results.add(new MediaItemWrapper(Category.ARTIST,
                            createBrowsableMediaItemForSubCategory(category, subCategory, metadata)));
                }
            }
            if (results.size() == 0) {
                results.add(new MediaItemWrapper(FireApplication.getInstance().getResources().getString(R.string.nothing_found)));
            }
            initialized = true;
        } catch (Exception e) {
            FireLog.e(TAG, "Media Initialization failed", e);
        }
        return initialized;
    }

