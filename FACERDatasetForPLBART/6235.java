        public void swapResult(DirectoryResult result) {
            mCursor = result != null ? result.cursor : null;
            mCursorCount = mCursor != null ? mCursor.getCount() : 0;

            mFooters.clear();

            final Bundle extras = mCursor != null ? mCursor.getExtras() : null;
            if (extras != null) {
                final String info = extras.getString(DocumentsContract.EXTRA_INFO);
                if (info != null) {
                    mFooters.add(new MessageFooter(2, R.drawable.ic_dialog_info, info));
                }
                final String error = extras.getString(DocumentsContract.EXTRA_ERROR);
                if (error != null) {
                    mFooters.add(new MessageFooter(3, R.drawable.ic_dialog_alert, error));
                }
                if (extras.getBoolean(DocumentsContract.EXTRA_LOADING, false)) {
                    mFooters.add(new LoadingFooter());
                }
            }

            if (result != null && result.exception != null) {
                mFooters.add(new MessageFooter(
                        3, R.drawable.ic_dialog_alert, getString(R.string.query_error)));
            }

            if (isEmpty()) {
                mEmptyView.setVisibility(View.VISIBLE);
            } else {
                mEmptyView.setVisibility(View.GONE);
            }

            notifyDataSetChanged();
        }

