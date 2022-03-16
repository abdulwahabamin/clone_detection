    public Bitmap decodeSampledBitmapFromAssets(String assetName, int reqWidth, int reqHeight) {
        try {
            InputStream ims = mContext.getAssets().open(assetName);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(ims, null, options);
            int scale = calculateInSampleSize(options, reqWidth, reqHeight);
            options = new BitmapFactory.Options();
            options.inSampleSize = scale;
            ims = mContext.getAssets().open(assetName);
            return BitmapFactory.decodeStream(ims, null, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

