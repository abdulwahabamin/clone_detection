	@Override
	public boolean isPlaying() {
		if(musicSRV!= null && musicBound){
			return musicSRV.isPng();
		}
		
		return false;
	}

