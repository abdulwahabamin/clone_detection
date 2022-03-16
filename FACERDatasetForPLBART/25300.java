    private Bitmap getAlbumArt(byte[] imageData) {
        Resources res = getResources();
        int height = (int) res.getDimension(android.R.dimen.notification_large_icon_height);
        int width = (int) res.getDimension(android.R.dimen.notification_large_icon_width);
        Bitmap largeIcon = BitmapUtils.decodeSampledBitmapFromResource(imageData, 200, 200);
        return Bitmap.createScaledBitmap(largeIcon, width, height, false);
    }

