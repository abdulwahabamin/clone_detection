    private void compressImage(final String path) {
        File file = new File(path);
        if (!file.exists()) {
            SnackbarUtils.show(this, R.string.image_open_fail);
            return;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        int inSampleSize;
        int max = Math.max(options.outWidth, options.outHeight);
        inSampleSize = max / 800;
        options.inJustDecodeBounds = false;
        options.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        bitmap = ImageUtils.autoRotate(path, bitmap);
        String savePath = ImageUtils.save2File(this, bitmap);
        if (!TextUtils.isEmpty(savePath)) {
            UploadImageActivity.start(this, mLocation, savePath);
        } else {
            SnackbarUtils.show(this, R.string.image_save_fail);
        }
    }

