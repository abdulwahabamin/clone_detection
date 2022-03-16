		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			intent.putExtra("mp3info", info);		//transfer "play" message to the player service
			intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG);
			intent.setClass(PlayerActivity.this, PlayerService.class);
//			if(isReleased){
//				isReleased=false;
//				prepareLrc(info.getLrcName());
//				begin=System.currentTimeMillis();
//			}else if(isPaused){
//				begin=System.currentTimeMillis()-pauseTimeMills+begin;
//			}
//			isPaused=false;
			startService(intent);
//			handler.postDelayed(updateTimeCallBack,5);
		}

