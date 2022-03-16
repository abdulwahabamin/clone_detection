    private String get_IDColumnName(String category) {
        String columnName;
        if (category.equals(MEDIA_ID_PLAYLIST)) {
            columnName = MediaStore.Audio.Playlists.Members.AUDIO_ID;
        } else {
            columnName = MediaStore.Audio.Media._ID;
        }
        return columnName;
    }

