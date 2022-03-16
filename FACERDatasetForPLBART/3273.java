        @Override
        protected Boolean doInBackground(Boolean... params) {
            //boolean stopAction=false;
//synchronized ("img.sync."+image.getPath()) {
            cb = ImageCache.get(image.getPath());
            //if (cb == null) {


            cb.bitmap = ThumbnailUtils.extractThumbnail(BitmapFunctions.getBitmap(mContext,image), width, height);

            cb.status = ImageCache.CACHE_B_LOADED;
            ImageCache.putFinal(image.getPath(), cb);

            //} else {
            //    stopAction=true;

            //}

            return true;

        }

