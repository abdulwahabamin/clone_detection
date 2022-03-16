		@Override
		public void onClick(View v) {
			Intent intent=new Intent();  //transfer "pause" message to the player service
			intent.putExtra("MSG", AppConstant.PlayerMsg.PAUSE_MSG);
			intent.setClass(PlayerActivity.this, PlayerService.class);
			startService(intent);
			
//			handler.removeCallbacks(updateTimeCallBack);
//			if(!isPaused)
//				pauseTimeMills=System.currentTimeMillis();
//			
//			isPaused=true;
		}

