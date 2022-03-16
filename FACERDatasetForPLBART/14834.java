		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			
			MusicBinder binder = (MusicBinder)service;
			
			//get the musicplayer service
			musicSRV = binder.getService();
			
			//pass on the list
			musicSRV.setSongList(songList);
			musicBound = true;
		}

