    /**
     * Get the list of music tracks from a server and caches the track information
     * for future reference, keying tracks by musicId and grouping by genre.
     * @param callback callback method ia called then done retrieving media
     */
    @SuppressWarnings("WeakerAccess")
    public void retrieveMediaAsync(@NonNull final MusicProvider.Callback callback) {
        Log.d(TAG, "retrieveMediaAsync:called");
        if (mCurrentState == MusicProvider.State.INITIALIZED) {

            // Nothing to do, execute callback immediately
            callback.onMusicCatalogReady(true);
            return;
        }

        // Asynchronously load the music catalog in a separate thread
        new AsyncTask<Void, Void, MusicProvider.State>() {
            @Override
            protected MusicProvider.State doInBackground(Void... params) {
                retrieveMedia();
                return mCurrentState;
            }

            @Override
            protected void onPostExecute(MusicProvider.State current) {
                callback.onMusicCatalogReady(current == MusicProvider.State.INITIALIZED);
            }
        }.execute();
    }

