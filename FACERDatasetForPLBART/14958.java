        public void onPageSelected(int cur) {            
        	if(cur == 0){
    			ImageButton mCButton = (ImageButton)findViewById(R.id.view_more);
    			mCButton.setImageResource(R.drawable.view_more_album);
    			TextView lineTwoView = (TextView)findViewById(R.id.half_artist_image_text_line_two);
    			String lineTwo = MusicUtils.makeAlbumsLabel(TracksBrowser.this, Integer.parseInt(getNumAlbums()), 0, false);
    	        lineTwoView.setText(lineTwo);
    		}else{
            	ImageButton mCButton = (ImageButton)findViewById(R.id.view_more);
    			mCButton.setImageResource(R.drawable.view_more_song);
    			TextView lineTwoView = (TextView)findViewById(R.id.half_artist_image_text_line_two);
    	        String lineTwo = MusicUtils.makeAlbumsLabel(TracksBrowser.this, 0, Integer.parseInt(getNumSongs()), true);
    			lineTwoView.setText(lineTwo);
    		}
	    }

