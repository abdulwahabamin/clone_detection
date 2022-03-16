	@Override
	public void onCompletion(MediaPlayer mp) {
		if(player.getCurrentPosition() > 0){
			mp.reset();
			playNext( );
		}
		
	}

