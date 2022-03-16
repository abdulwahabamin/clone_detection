        @Override
        protected Bitmap doInBackground(Bitmap... loadedImage) {
            Bitmap drawable = null;
            try {
                drawable = createBlurredBitmapFromBitmap(loadedImage[0], context, IN_SAMPLE_SIZE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return drawable;
        }

