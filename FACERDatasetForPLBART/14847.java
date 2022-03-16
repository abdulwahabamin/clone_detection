	@Override
	public int getCurrentPosition() {
	
		if(musicSRV!=null && musicBound && musicSRV.isPng()){
			
		    return musicSRV.getPosn();
		}
		else return 0;
	}

