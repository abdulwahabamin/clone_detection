    @Override
    protected void onPostExecute(Cursor cursor) {
        if (mListener != null) {
            mListener.onCursor(cursor);
        }
    }

