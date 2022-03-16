    @Override
    public void onLoadChildren(@NonNull final String parentMediaId,
                               @NonNull final Result<List<MediaBrowserCompat.MediaItem>> result) {
        Log.d(TAG, "onLoadChildren: parentMediaId="+parentMediaId);
        if (MediaIdHelper.MEDIA_ID_EMPTY_ROOT.equals(parentMediaId)) {
            result.sendResult(new ArrayList<MediaBrowserCompat.MediaItem>());
        } else if (parentMediaId.startsWith(MediaIdHelper.MEDIA_ID_PLAYLISTS)) {
            if (mPlaylistsManager.isInitialized()) {
                // if music library is ready, return immediately
                result.sendResult(mPlaylistsManager.getChildren(parentMediaId));
            } else {
                // otherwise, only return results when the music library is retrieved
                result.detach();
                mPlaylistsManager.retrievePlaylistsAsync(new PlaylistsManager.Callback() {
                    @Override
                    public void onPlaylistCatalogReady(boolean success) {
                        result.sendResult(mPlaylistsManager.getChildren(parentMediaId));
                    }
                });
            }
        } else if (mMusicProvider.isInitialized()) {
            // if music library is ready, return immediately
            result.sendResult(mMusicProvider.getChildren(parentMediaId));
        } else {
            // otherwise, only return results when the music library is retrieved
            result.detach();
            mMusicProvider.retrieveMediaAsync(new MusicProvider.Callback() {
                @Override
                public void onMusicCatalogReady(boolean success) {
                    result.sendResult(mMusicProvider.getChildren(parentMediaId));
                }
            });
        }
    }

