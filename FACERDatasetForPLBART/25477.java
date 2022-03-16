	private synchronized void jumpTo(int position){
		if(mp.isPlaying()){
			mp.seekTo(position);
		} else {
			// if we're paused but initialized, try to seek
			try{
				mp.seekTo(position);
				lastPosition = mp.getCurrentPosition();
			} catch (Exception e){
				Log.w(TAG, "Unable to seek to position, file may not have been loaded");
			}
		}
	}

