	private void play(MP3Info info) {
		if (player == null) {
			String path = getMP3Path(info);
			player = MediaPlayer.create(this, Uri.parse("file://" + path));
			player.setLooping(false);
			player.setOnCompletionListener(new OnCompletionListener() {				
				@Override				//call back method when songs finished
				public void onCompletion(MediaPlayer mp) {
					player.release();
					isReleased = true;
					handler.removeCallbacks(updateTimeCallBack);
					player=null;
				}
			});
			prepareLrc(info.getLrcName());     //initial the lrc enviroment
			begin=System.currentTimeMillis();
		}
		if(isPausing)
			begin=System.currentTimeMillis()-pauseTimeMills+begin;
		player.start();
		isReleased = false;
		isPausing = false;
		
		handler.postDelayed(updateTimeCallBack,5);  //post the callback into message queue
	}

