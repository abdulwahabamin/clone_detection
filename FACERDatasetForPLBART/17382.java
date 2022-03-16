    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName,
                                 int clientUid,
                                 @Nullable Bundle rootHints) {

        Log.d(TAG, "onGetRoot:called");
        Log.i(TAG, "onGetRoot:clientUid="+clientUid);
        Log.i(TAG, "onGetRoot:clientPackageName="+clientPackageName);

        Log.i(TAG, "onGetRoot:rootHints="+rootHints);

        //noinspection ConstantConditions
        if (allowBrowsing(clientPackageName, clientUid)) {
            // checking root hint for appropriate root_id
            if (rootHints != null) {
                String rootHint =
                        rootHints.getString(getResources().getString(R.string.root_hint_key));
                if (rootHint != null) {
                    switch (rootHint) {
                        case MediaIdHelper.ALL_SONGS_ROOT_HINT:
                            return new BrowserRoot(MediaIdHelper.MEDIA_ID_ALL_SONGS, null);
                        case MediaIdHelper.ALBUMS_ROOT_HINT:
                            return new BrowserRoot(MediaIdHelper.MEDIA_ID_ALBUMS, null);
                        case MediaIdHelper.ARTISTS_ROOT_HINT:
                            return new BrowserRoot(MediaIdHelper.MEDIA_ID_ARTISTS, null);
                        case MediaIdHelper.PLAYLISTS_ROOT_HINT:
                            return new BrowserRoot(MediaIdHelper.MEDIA_ID_PLAYLISTS, null);
                        default:
                            return new BrowserRoot(MediaIdHelper.MEDIA_ID_EMPTY_ROOT, null);
                    }
                } else {
                    // returning null
                    return new BrowserRoot(MediaIdHelper.MEDIA_ID_EMPTY_ROOT, null);
                }
            } else {
                // returning null
                return new BrowserRoot(MediaIdHelper.MEDIA_ID_EMPTY_ROOT, null);
            }
        } else {
            // Clients can connect, but since the BrowserRoot is an empty string
            // onLoadChildren will return nothing. This disables the ability to browse for content.
            return new BrowserRoot(MediaIdHelper.MEDIA_ID_EMPTY_ROOT, null);
        }
    }

