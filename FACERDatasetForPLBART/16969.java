    private static void loadBlurBg(Context context, ImageView view, Bitmap loadedImage, String key) {
        FireLog.d(TAG, "(++) loadBlurBg: context=" + context + ", view=" + view + ", loaded image="
                + loadedImage + ", key=" + key);

        if (context == null || view == null || loadedImage == null) {
            return;
        }

        /*
         * if blurred image is found in cache then load it from cache
         */
        if (key != null && blurredDrawableCache.get(key) != null) {
            Bitmap drawable = blurredDrawableCache.get(key);
            setBackground(context, view, drawable);
            return;
        }

        /*
         * if key not found in cache load blurred image async
         */
        LoadBlurredImageTask blurredImageTask = new LoadBlurredImageTask(context, view, key);
        blurredImageTask.execute(loadedImage);
    }

