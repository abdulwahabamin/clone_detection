    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // Dialog doesn't allow us to wait for a result, so we need to store
        // the info we need for when the dialog posts its result
        mQueryCursor.moveToPosition(position);
        if (mQueryCursor.isBeforeFirst() || mQueryCursor.isAfterLast()) {
            return;
        }
        String selectedType = mQueryCursor.getString(mQueryCursor
                .getColumnIndexOrThrow(Audio.Media.MIME_TYPE));

        if ("artist".equals(selectedType)) {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            TextView tv1 = (TextView)v.findViewById(R.id.listview_item_line_one);
            String artistName = tv1.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString(MIME_TYPE, Audio.Artists.CONTENT_TYPE);
            bundle.putString(ARTIST_KEY, artistName);
            bundle.putLong(BaseColumns._ID, id);

            intent.setClass(this, TracksBrowser.class);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else if ("album".equals(selectedType)) {
            TextView tv1 = (TextView)v.findViewById(R.id.listview_item_line_one);
            TextView tv2 = (TextView)v.findViewById(R.id.listview_item_line_two);

            String artistName = tv2.getText().toString();
            String albumName = tv1.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString(MIME_TYPE, Audio.Albums.CONTENT_TYPE);
            bundle.putString(ARTIST_KEY, artistName);
            bundle.putString(ALBUM_KEY, albumName);
            bundle.putLong(BaseColumns._ID, id);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClass(this, TracksBrowser.class);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else if (position >= 0 && id >= 0) {
            long[] list = new long[] {
                id
            };
            MusicUtils.playAll(this, list, 0);
        } else {
            Log.e("QueryBrowser", "invalid position/id: " + position + "/" + id);
        }
    }

