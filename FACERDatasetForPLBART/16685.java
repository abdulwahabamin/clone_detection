    private List<MediaMetadataCompat> getLocalFolders() {
        FireLog.d(TAG, "(++) getLocalFolders");
        List<MediaMetadataCompat> folders = new ArrayList<>();

        Uri songsUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {"*"};
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != ?";
        String[] selectionArgs = {"0"};
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";

        Cursor cursor = FireApplication.getInstance().getContentResolver()
                .query(songsUri, projection, selection, selectionArgs, sortOrder);

        // Using set for finding distinct folder
        Set<String> set = new HashSet<>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    String path = data.substring(0, data.lastIndexOf("/"));
                    if (set.add(path)) {
                        MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat.Builder()
                                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID,
                                        path)
                                .putString(MediaMetadataCompat.METADATA_KEY_TITLE,
                                        path.substring(path.lastIndexOf("/") + 1, path.length()))
                                .putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI,
                                        getAlbumArt(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))))
                                .build();
                        folders.add(mediaMetadataCompat);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return folders;
    }

