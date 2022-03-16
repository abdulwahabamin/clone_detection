	public void playNext( ){
		
		if(shuffle){
			int newSong = songPosition;
			while(newSong == songPosition){
				newSong = rand.nextInt(songs.size());
			}
			
			songPosition = newSong;
		}
		
		else{
			songPosition++;
			if(songPosition >= songs.size()) songPosition = 0; 
			playSong();
		}

	}

