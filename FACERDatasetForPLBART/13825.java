    public List<Music> getAllAudioFromDevice(final Context context) {

        final List<Music> downloadedAudioList = new ArrayList<>();

        String folder = SharedPrefUtils.getDownloadedFolder(context);
        Uri uri = MediaStore.Files.getContentUri("external");
        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.Media.DURATION, MediaStore.Audio.ArtistColumns.ARTIST, MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.SIZE,};
        String selection = "(" + MediaStore.Files.FileColumns.MEDIA_TYPE + " = "
                + MediaStore.Files.FileColumns.MEDIA_TYPE_AUDIO + " OR "
                + MediaStore.Files.FileColumns.MEDIA_TYPE + " = "
                + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO + ") AND "
                + MediaStore.Audio.Media.DATA + " like ? ";

        Cursor cursor = context.getContentResolver().query(uri, projection, selection, new String[]{"%" + folder + "%"}, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Music music = new Music();
                music.buildObjectFromCursor(cursor);
                downloadedAudioList.add(music);
            }
            cursor.close();
        }

        return downloadedAudioList;
    }

