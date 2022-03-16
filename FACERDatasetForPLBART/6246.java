        public ThumbnailAsyncTask(
                Uri uri, ImageView iconMime, ImageView iconThumb, Point thumbSize) {
            mUri = uri;
            mIconMime = iconMime;
            mIconThumb = iconThumb;
            mThumbSize = thumbSize;
            mSignal = new CancellationSignal();
        }

