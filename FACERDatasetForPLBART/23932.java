    private void parseLine(String musicDir, ArrayList<Long> songIds, String line) {
        if (!line.isEmpty() && line.charAt(0) != '#') {
            String songPath = (line.charAt(0) == '/') ? line : musicDir + '/' + line;
            Cursor cursor = context.getContentResolver().query(
                    MediaStore.Audio.Media.getContentUriForPath(songPath),
                    new String[] { MediaStore.Audio.AudioColumns._ID },
                    MediaStore.Audio.AudioColumns.DATA + "=?",
                    new String[] { songPath },
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                long id = cursor.getLong(0);
                songIds.add(id);
            }
            if (cursor != null) cursor.close();
        }
    }

