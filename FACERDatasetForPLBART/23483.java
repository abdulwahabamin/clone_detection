        TrackListAdapter(Context context, ListView listView, int layout,
                String[] from, int[] to) {
            super(context, layout, null, from, to);
            mListView = listView;
            mUnknownArtist = context.getString(R.string.unknown_artist_name);
            mUnknownAlbum = context.getString(R.string.unknown_album_name);
        }

