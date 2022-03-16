    public List<Music> getFavoriteAudioFromDevice(final Context context) {

        final List<Music> downloadedAudioList = new ArrayList<>();

        Uri uri = MediaStore.Files.getContentUri("external");
        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.Media.DURATION, MediaStore.Audio.ArtistColumns.ARTIST, MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.SIZE,};
        String selection = MediaStore.Audio.Media._ID + " IN ( " + TextUtils.join(", ", getAllFavorites()) + " )";

        Cursor cursor = context.getContentResolver().query(uri, projection, selection, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Music music = new Music();
                music.buildObjectFromCursor(cursor);
                music.setFavorite(true);
                downloadedAudioList.add(music);
            }
            cursor.close();
        }

        return downloadedAudioList;
    }

