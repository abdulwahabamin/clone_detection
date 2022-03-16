    private Bitmap getAlbumArt() {
    	mApp = (Common) mContext.getApplicationContext();
    	
        //Check if the album art has been cached for this song.
        File albumArtFile = new File(mContext.getExternalCacheDir() + "/current_album_art.jpg");
        Bitmap bm = null;
        if (albumArtFile.exists() && mApp.isServiceRunning()) {
        	//Decode a subsampled version of the cached album art.
        	bm = mApp.decodeSampledBitmapFromFile(albumArtFile, 450, 450);
        } else if (!albumArtFile.exists() && mApp.isServiceRunning()) {
        	//Decode a subsampled version of the default album art.
            bm = mApp.decodeSampledBitmapFromResource(R.drawable.transparent_drawable, 450, 450);
        } else {
        	return null;
        }
        
        return bm;
    }

