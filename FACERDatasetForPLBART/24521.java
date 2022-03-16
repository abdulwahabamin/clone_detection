    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        adapter.setMapper(new CursorMapper() {
            private int durationColumnIndex;
            private int artistColumnIndex;
            private int titleColumnIndex;
            private int idColumnIndex;

            @Override
            protected void bindColumns(Cursor cursor) {
                idColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns._ID);
                titleColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE);
                artistColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST);
                durationColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DURATION);
            }

            @Override
            protected Object bind(Cursor cursor) {
                return new SongItem(
                        cursor.getPosition(),
                        cursor.getLong(idColumnIndex),
                        cursor.getString(titleColumnIndex),
                        cursor.getString(artistColumnIndex),
                        cursor.getInt(durationColumnIndex));
            }
        });
        adapter.changeCursor(cursor);
    }

