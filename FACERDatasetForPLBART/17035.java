    @Override
    public List<MediaMetadataCompat> getSongListFromLocalStorage() {
        List<MediaMetadataCompat> songList = new ArrayList<>();
        Cursor songsCursor = getSongsCursor();

        if (songsCursor.moveToFirst()) {
            do {
                songList.add(buildSongMetadata(songsCursor));
            } while (songsCursor.moveToNext());
        }

        return songList;
    }

