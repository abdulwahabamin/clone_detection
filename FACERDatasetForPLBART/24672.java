		@Override
		public void onClick(View v) {
			Intent intent=new Intent();  //transfer "stop" message to the player service
			intent.putExtra("MSG", AppConstant.PlayerMsg.STOP_MSG);
			intent.setClass(PlayerActivity.this, PlayerService.class);
			startService(intent);

//			handler.removeCallbacks(updateTimeCallBack);
//			isReleased=true;
		}

