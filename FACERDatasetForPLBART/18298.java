    private Bitmap getAlbumArt() {
    	mApp = (Common) mContext.getApplicationContext();
    	
        //Check if the album art has been cached for this song.
        File albumArtFile = new File(mContext.getExternalCacheDir() + "/current_album_art.jpg");
        Bitmap bm = null;
        if (albumArtFile.exists()) {
        	//Decode a subsampled version of the cached album art.
        	bm = mApp.decodeSampledBitmapFromFile(albumArtFile, 150, 150);
        } else {
        	//Decode a subsampled version of the default album art.
            bm = mApp.decodeSampledBitmapFromResource(R.drawable.default_album_art, 150, 150);
        }
        
        return bm;
    }

