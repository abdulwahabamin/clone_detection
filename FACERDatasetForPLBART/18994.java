        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            mIsAlbumArtLoaded = true;
            setAlbumArt(bitmap);
            if (getAlbumArtLoadedListener()!=null)
                getAlbumArtLoadedListener().albumArtLoaded();

            if (mIsCurrentSong) {
                mApp.getService().updateNotification(mSongHelper);
                mApp.getService().updateWidgets();

            }

        }

