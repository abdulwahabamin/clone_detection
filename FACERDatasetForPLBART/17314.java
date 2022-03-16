    @SuppressWarnings("WeakerAccess")
    public void retrievePlaylistsAsync(@NonNull final Callback callback) {
        Log.d(TAG, "retrievePlaylistsAsync:called");
        if (mCurrentState == PlaylistsManager.State.INITIALIZED) {

            // Nothing to do, execute callback immediately
            callback.onPlaylistCatalogReady(true);
            return;
        }

        // Asynchronously load the music catalog in a separate thread
        new AsyncTask<Void, Void, PlaylistsManager.State>() {
            @Override
            protected PlaylistsManager.State doInBackground(Void... params) {
                retrievePlaylists();
                return mCurrentState;
            }

            @Override
            protected void onPostExecute(PlaylistsManager.State current) {
                callback.onPlaylistCatalogReady(current == PlaylistsManager.State.INITIALIZED);
            }
        }.execute();
    }

