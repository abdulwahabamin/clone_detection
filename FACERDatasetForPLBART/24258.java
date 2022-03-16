    private long[] fetchSongList(String folder) {
        Cursor cursor = MusicUtils.query(getActivity(),
                MusicContract.Folder.getMembersUri(folder),
                new String[] { MediaStore.Audio.AudioColumns._ID },
                null,
                null,
                null);

        if (cursor != null) {
            long [] list = MusicUtils.getSongListForCursor(cursor);
            cursor.close();
            return list;
        }
        return MusicUtils.sEmptyList;
    }

