        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            setAlbumArt(null);
            onBitmapLoaded(mAlbumArt, null);

        }

