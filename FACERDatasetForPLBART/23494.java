        @Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            if (!isFinishing()) {
                // Update the adapter: we are no longer loading, and have
                // a new cursor for it.
                mAdapter.setLoading(false);
                mAdapter.changeCursor(cursor);
                setProgressBarIndeterminateVisibility(false);
    
                // Now that the cursor is populated again, it's possible to restore the list state
                if (mListState != null) {
                    getListView().onRestoreInstanceState(mListState);
                    if (mListHasFocus) {
                        getListView().requestFocus();
                    }
                    mListHasFocus = false;
                    mListState = null;
                }
            } else {
                cursor.close();
            }
        }

