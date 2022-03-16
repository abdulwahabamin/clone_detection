    private Uri getUri(String category, String subCategory) {
        FireLog.d(TAG, "(++) getUri, category=" + category + ", subCategory=" + subCategory);
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        if (category.equals(MEDIA_ID_PLAYLIST)) {
            long playListId = Long.parseLong(subCategory);
            uri = MediaStore.Audio.Playlists.Members.getContentUri("external", playListId);
        } else if (category.equals(MEDIA_ID_GENRE)) {
            long genreId = Long.parseLong(subCategory);
            uri = MediaStore.Audio.Genres.Members.getContentUri("external", genreId);
        }
        return uri;
    }

