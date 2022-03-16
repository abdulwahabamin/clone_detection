	public void playPrev( ){
		musicSRV.playPrev();
		
		if(playbackPaused){
			setController( );
			playbackPaused=false;
		}
		controller.show(0);
	}

