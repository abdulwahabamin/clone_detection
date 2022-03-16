    public void searchAsync(final @NonNull String query) {
        FireLog.d(TAG, "(++) searchAsync");
        if (asyncTask != null) {
            asyncTask.cancel(false);
            asyncTask = null;
        }
        asyncTask = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                return retrieveMedia(query);
            }

            @Override
            protected void onPostExecute(Boolean initialized) {
                if (initialized && searchCallback != null) {
                    searchCallback.onSearchResult(query, bundle, results);
                }
            }
        }.executeOnExecutor(executorService);
    }

