    private ArrayList<Song> getGenreSongs(long genreId) {
        Log.d(TAG, "getGenreSongs() entry");

        ArrayList<Song> rsltPlayList = new ArrayList<>();
        final Uri musicUri = MediaStore.Audio.Genres.Members.getContentUri("external", genreId);

        ContentResolver musicResolver = getContentResolver();
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if (musicCursor != null && musicCursor.moveToFirst()) {
            //get columns
            int idColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media._ID);
            int albumColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.ALBUM);
            int albumIdColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.ALBUM_ID);
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int composerColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.COMPOSER);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            int trackColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.TRACK);
            //add songs to list
            do {
                // Log.d(TAG, "getGenreSongs(): Adding '"+musicCursor.getString(titleColumn)+"' ("+musicCursor.getString(albumColumn)+")");
                rsltPlayList.add(new Song(musicCursor.getLong(idColumn),
                        musicCursor.getString(titleColumn),
                        musicCursor.getString(artistColumn),
                        musicCursor.getString(albumColumn),
                        genSortTitle(musicCursor.getString((albumColumn))),
                        musicCursor.getLong(albumIdColumn),
                        musicCursor.getString(composerColumn),
                        musicCursor.getInt(trackColumn)));
            }
            while (musicCursor.moveToNext());
            musicCursor.close();
        }
        Collections.sort(rsltPlayList, (a, b) -> {
            // Sort by album title. If two titles the same, differentiate by ID.
            // Within album, sort by track. If two tracks claim the same position
            // differentiate by title.

            int rslt = a.getAlbumSortTitle().compareTo(b.getAlbumSortTitle());
            if (rslt == 0)
                rslt = (int) (a.getAlbumId() - b.getAlbumId());
            if (rslt == 0)
                rslt = a.getTrack() - b.getTrack();
            if (rslt == 0)
                rslt = a.getTitle().compareTo(b.getTitle());
            return rslt;
        });
        return rsltPlayList;
    }

