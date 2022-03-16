	public void songPicked(View view){
		musicSRV.setSong(Integer.parseInt(view.getTag( ).toString()));
		musicSRV.playSong();
		
		if(playbackPaused){
			setController( );
			playbackPaused = false;
		}
		
		controller.show(0);
	}

