	public void playNext( ){
		musicSRV.playNext();
		
		if(playbackPaused){
			setController();
			playbackPaused = false;
		}
		controller.show(0);
	}

