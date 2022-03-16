		@Override
		public void onClick(View v) {
			if(player==null){
				String path=getMP3Path(info);
				player=MediaPlayer.create(PlayerActivity.this,Uri.parse("file://"+path));
				player.setLooping(false);
			}
			player.start();
			isReleased=false;
			isPausing=false;
		}

