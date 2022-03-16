	public void setController( ){
		controller = new MusicController(this);
		
		controller.setPrevNextListeners(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
			    playNext();
			  }
			}, new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
			    playPrev();
			  }
			});
		
		controller.setMediaPlayer(this);
		controller.setAnchorView(findViewById(R.id.song_list));
		controller.setEnabled(true);
		
	}

