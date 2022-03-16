            @Override
            protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
                //Log.i("@@@", "query complete: " + cursor.getCount() + "   " + mActivity);
                if (cursor != null) {
                    cursor = mActivity.mergedCursor(cursor);
                }
                mActivity.init(cursor);
            }

