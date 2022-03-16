    public static void updateMusicDB(Context context) {
        if (!isUpdating) {
            isUpdating = true;
            getMusicContent(context);
            isUpdating = false;
        }
    }

