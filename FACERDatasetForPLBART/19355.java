    public void updateSongInfo() {

    	if (mCursor!=null && (mApp.getService().getPlaybackIndecesList().size() > 0)) {
    		
    		if (CALLED_FROM_REMOVE) {
    			if ((mApp.getService().getCurrentSongIndex()-1) < mApp.getService().getPlaybackIndecesList().size() &&
    				 (mApp.getService().getCurrentSongIndex()-1) > -1) {
    				mCursor.moveToPosition(mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()-1));
    			}
    		} else {
    			if (mApp.getService().getCurrentSongIndex() < mApp.getService().getPlaybackIndecesList().size()) {
    				mCursor.moveToPosition(mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()));
    			}
    			
    		}
    		
    		//Retrieve and set the current title/artist/artwork.
    		
    		String currentTitle = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_TITLE));
    		String currentArtist = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST));
    		
    		nowPlayingSongTitle.setText(currentTitle);
    		nowPlayingSongArtist.setText(currentArtist);    		
    		
    		File file = new File(mContext.getExternalCacheDir() + "/current_album_art.jpg");
    		Bitmap bm = null;
    		if (file.exists()) {
    			bm = mApp.decodeSampledBitmapFromFile(file, screenWidth, screenHeight);
    			nowPlayingAlbumArt.setScaleX(1.0f);
    			nowPlayingAlbumArt.setScaleY(1.0f);
    		} else {
    			int defaultResource = UIElementsHelper.getIcon(mContext, "default_album_art");
    			bm = mApp.decodeSampledBitmapFromResource(defaultResource, screenWidth, screenHeight);
    			nowPlayingAlbumArt.setScaleX(0.5f);
    			nowPlayingAlbumArt.setScaleY(0.5f);
    		}

    		nowPlayingAlbumArt.setImageBitmap(bm);
			progressBar.setVisibility(View.GONE);
			playPauseButton.setVisibility(View.VISIBLE);
			previousButton.setVisibility(View.VISIBLE);
			nextButton.setVisibility(View.VISIBLE);

    		//Set the controls.
    		if (mApp.getService().getCurrentMediaPlayer().isPlaying()) {
    			playPauseButton.setImageResource(R.drawable.pause_holo_light);
    		} else {
    			playPauseButton.setImageResource(R.drawable.play_holo_light);
    		}
    		
    	} else {
    		//The service is stopped, so reset the fragment back to its uninitialized state.
    		//nowPlayingAlbumArt.setImageBitmap(NowPlayingQueueActivity.defaultArtworkBitmap);
        	noMusicPlaying.setVisibility(View.VISIBLE);
        	nowPlayingQueueListView.setVisibility(View.GONE);
        	nowPlayingSongTitle.setVisibility(View.GONE);
        	nowPlayingSongArtist.setVisibility(View.GONE);
        	
			nowPlayingSongTitle.setText("");
			nowPlayingSongArtist.setText("");
			nowPlayingAlbumArt.setImageBitmap(mApp.decodeSampledBitmapFromResource(R.drawable.default_album_art, screenWidth, screenWidth));
			
			progressBar.setVisibility(View.GONE);
			playPauseButton.setVisibility(View.GONE);
			previousButton.setVisibility(View.GONE);
			nextButton.setVisibility(View.GONE);
			
    	}
    	
    	//Update the listview.
    	nowPlayingQueueListViewAdapter.notifyDataSetChanged();
    	
    	CALLED_FROM_REMOVE = false;
		
    }

