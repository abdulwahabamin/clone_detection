    public Bitmap getArtwork(Context mContext) {
        Bitmap artwork = null;
        try {
            Uri trackUri = ContentUris.withAppendedId(
                    android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(mContext, trackUri);

            byte[] data = mmr.getEmbeddedPicture();

            // convert the byte array to a bitmap
            if (data != null)
                artwork = BitmapFactory.decodeByteArray(data, 0, data.length);
        } catch (Exception e) {
            Log.e("MUSIC SERVICE", "Error getting album artwork", e);
            artwork = null;
        }
        if (artwork == null) {
            Drawable drawable = mContext.getDrawable(R.drawable.ic_launcher_icon);
            if (drawable != null) {
                artwork = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(artwork);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
        }
        return artwork;
    }

