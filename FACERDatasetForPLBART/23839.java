    private void getGenreList() {
        final Uri genreUri = MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI;

        Log.d(TAG, "getGenreList() entry");
        if (genres.size() == 0) {
            ContentResolver genreResolver = getContentResolver();
            Cursor genreCursor = genreResolver.query(genreUri, null, null, null, null);

            if (genreCursor != null && genreCursor.moveToFirst()) {
                int idColumn = genreCursor.getColumnIndex(MediaStore.Audio.Genres._ID);
                int nameColumn = genreCursor.getColumnIndex(MediaStore.Audio.Genres.NAME);

                do {
                    genres.add(new Genre(
                            genreCursor.getLong(idColumn),
                            genreCursor.getString(nameColumn)
                    ));
                } while (genreCursor.moveToNext());
                genreCursor.close();
            }
            Collections.sort(genres, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        }
    }

