    @Override
    public List<MediaMetadataCompat> getAlbumListFromLocalStorage() {
        List<MediaMetadataCompat> albumList = new ArrayList<>();
        Cursor albumsCursor = getAlbumsCursor();

        if (albumsCursor.moveToFirst()) {
            do {
                albumList.add(buildAlbumMetadata(albumsCursor));
            } while (albumsCursor.moveToNext());
        }

        return albumList;
    }

