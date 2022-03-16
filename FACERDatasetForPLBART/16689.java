    private String getSelection(String category, String subCategory) {
        FireLog.d(TAG, "(++) getSelection, category= " + category + ", subCategory=" + subCategory);
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        if (category.equals(MEDIA_ID_ALBUM)) {
            selection += " AND " + MediaStore.Audio.Media.ALBUM_ID + " == " + subCategory;
        } else if (category.equals(MEDIA_ID_ARTIST)) {
            selection += " AND " + MediaStore.Audio.Media.ARTIST_ID + " == " + subCategory;
        } else if (category.equals(MEDIA_ID_FOLDER)) {
            // in case of folder subcategory = path
            selection += " AND " + MediaStore.Audio.Media.DATA + " LIKE '" + subCategory + "%'";
        }
        return selection;
    }

