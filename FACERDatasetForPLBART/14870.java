	public void playSong(){
		player.reset();
		
		Song playSong= songs.get(songPosition);
		songTitle = playSong.getSongTitle( );
		long currSong = playSong.getSongId();
		
		Uri trackUri = ContentUris.withAppendedId(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, currSong);
		
		try{
			player.setDataSource(getApplicationContext(), trackUri);
		}
		
		catch(Exception e){
			Log.e("MUSIC SERVICE", "Error setting data source", e);
		}
		
		player.prepareAsync();
		
	}

