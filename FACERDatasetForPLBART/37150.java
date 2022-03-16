    public static void pickImage(Activity activity, PickType type) {
        if (type == PickType.CAMERA) {
            startCamera(activity);
        } else if (type == PickType.ALBUM) {
            startAlbum(activity);
        }
    }

