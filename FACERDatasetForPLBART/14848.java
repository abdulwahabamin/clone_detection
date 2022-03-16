	@Override
	public int getDuration() {
		if(musicSRV != null && musicBound && musicSRV.isPng()){
			return musicSRV.getDur();
		}
		
		else return 0;
		
	}

