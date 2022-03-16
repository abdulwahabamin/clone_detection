        @Override
        protected Boolean doInBackground(Boolean... params) {
            //BLog.e("POINT", "1");

            cb = ImageCache.get(image.getPath());
            if(cb==null) {
                cb=ImageCache.getNewCacheBitmap();
                cb.status=ImageCache.CACHE_B_LOADING;
                ImageCache.put(image.getPath(), cb);

                //cb.bitmap= ThumbnailUtils.extractThumbnail(BitmapFunctions.getPreview(image,width), width, height);
                cb.bitmap = ThumbnailUtils.extractThumbnail(BitmapFunctions.getBitmap(mContext,image), width, height);
                cb.status=ImageCache.CACHE_B_LOADED;
                ImageCache.putFinal(image.getPath(), cb);

            }
            return Boolean.TRUE;

        }

