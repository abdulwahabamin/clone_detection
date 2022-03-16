    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Swap the new cursor in. (The framework will take care of closing the old cursor once we return.)
        if (data != null) {
            if (data.moveToFirst()) {
                bindView(data);
            }
        }
    }

