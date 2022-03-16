    private Cursor getQueryCursor(AsyncQueryHandler async, String filter) {
        if (filter == null) {
            filter = "";
        }
        String[] ccols = new String[] {
                BaseColumns._ID, Audio.Media.MIME_TYPE, Audio.Artists.ARTIST, Audio.Albums.ALBUM,
                Audio.Media.TITLE, "data1", "data2"
        };

        Uri search = Uri.parse("content://media/external/audio/search/fancy/" + Uri.encode(filter));

        Cursor ret = null;
        if (async != null) {
            async.startQuery(0, null, search, ccols, null, null, null);
        } else {
            ret = MusicUtils.query(this, search, ccols, null, null, null);
        }
        return ret;
    }

