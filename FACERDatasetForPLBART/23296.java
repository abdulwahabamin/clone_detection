    private void MakeCursor() {
        String[] audiocols = new String[] {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.MIME_TYPE,
                MediaStore.Audio.Media.YEAR
        };
        String[] videocols = new String[] {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.MIME_TYPE
        };

        Cursor[] cs;
        // Use ArrayList for the moment, since we don't know the size of
        // Cursor[]. If the length of Corsor[] larger than really used,
        // a NPE will come up when access the content of Corsor[].
        ArrayList<Cursor> cList = new ArrayList<Cursor>();
        Intent intent = getIntent();
        String type = intent.getType();

        if (mFirstYear != null) {
            // If mFirstYear is not null, the picker only for audio because
            // video has no year column.
            if(type.equals("video/*")) {
                mCursor = null;
                return;
            }

            mWhereClause = MediaStore.Audio.Media.YEAR + ">=" + mFirstYear + " AND " +
                           MediaStore.Audio.Media.YEAR + "<=" + mLastYear;
        }

        // If use Cursor[] as before, the Cursor[i] could be null when there is
        // no video/audio/sdcard. Then a NPE will come up when access the content of the
        // Array.

        Cursor c;
        if (type.equals("video/*")) {
            // Only video.
            c = MusicUtils.query(this, MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    videocols, null , null, mSortOrder);
            if (c != null) {
                cList.add(c);
            }
        } else {
            c = MusicUtils.query(this, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    audiocols, mWhereClause , null, mSortOrder);

            if (c != null) {
                cList.add(c);
            }

            if (mFirstYear == null && intent.getType().equals("media/*")) {
                // video has no year column
                c = MusicUtils.query(this, MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    videocols, null , null, mSortOrder);
                if (c != null) {
                    cList.add(c);
                }
            }
        }

        // Get the ArrayList size.
        int size = cList.size();
        if (0 == size) {
            // If no video/audio/SDCard exist, return.
            mCursor = null;
            return;
        }

        // The size is known now, we're sure each item of Cursor[] is not null.
        cs = new Cursor[size];
        cs = cList.toArray(cs);
        mCursor = new SortCursor(cs, MediaStore.Audio.Media.TITLE);
    }

