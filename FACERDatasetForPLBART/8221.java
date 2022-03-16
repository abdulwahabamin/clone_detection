    /**
     * Method that initializes the bookmarks.
     */
    private synchronized void initBookmarks() {
        if (mBookmarksTask != null &&
                !mBookmarksTask.getStatus().equals(AsyncTask.Status.FINISHED)) {
            return;
        }

        // Retrieve the loading view
        final View waiting = findViewById(R.id.bookmarks_loading);

        // Load bookmarks in background
        mBookmarksTask = new AsyncTask<Void, Void, Boolean>() {
            Exception mCause;

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    mBookmarks = loadBookmarks();
                    return Boolean.TRUE;

                }
                catch (Exception e) {
                    this.mCause = e;
                    return Boolean.FALSE;
                }
            }

            @Override
            protected void onPreExecute() {
                waiting.setVisibility(View.VISIBLE);
                mDrawerBookmarks.removeAllViews();
            }

            @Override
            protected void onPostExecute(Boolean result) {
                waiting.setVisibility(View.GONE);
                if (result.booleanValue()) {
                    for (Bookmark bookmark : mBookmarks) {
                        addBookmarkToDrawer(bookmark);
                    }
                }
                else {
                    if (this.mCause != null) {
                        ExceptionUtil.translateException(
                                NavigationActivity.this, this.mCause);
                    }
                }
                mBookmarksTask = null;
            }

            @Override
            protected void onCancelled() {
                waiting.setVisibility(View.GONE);
                mBookmarksTask = null;
            }
        };
        mBookmarksTask.execute();
    }

