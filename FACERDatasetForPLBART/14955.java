    private void onToggleButton(){
    	if(mViewPager!=null){
    		int cur = mViewPager.getCurrentItem();
    		if(cur == 0){
    			mChangeButton.setImageResource(R.drawable.view_more_song);
    			mViewPager.setCurrentItem(1);
    			TextView lineTwoView = (TextView)findViewById(R.id.half_artist_image_text_line_two);
    	        String lineTwo = MusicUtils.makeAlbumsLabel(this, 0, Integer.parseInt(getNumSongs()), true);
    			lineTwoView.setText(lineTwo);
    		}else{
    			mChangeButton.setImageResource(R.drawable.view_more_album);
    			mViewPager.setCurrentItem(0);
    			TextView lineTwoView = (TextView)findViewById(R.id.half_artist_image_text_line_two);
    			String lineTwo = MusicUtils.makeAlbumsLabel(this, Integer.parseInt(getNumAlbums()), 0, false);
    	        lineTwoView.setText(lineTwo);
    		}
    	}    	
    }

