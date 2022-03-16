	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		MP3Info info = (MP3Info) intent.getSerializableExtra("mp3info");
		int MSG = intent.getIntExtra("MSG", 0);
		if (info != null) {
			if (MSG == AppConstant.PlayerMsg.PLAY_MSG) {
				play(info);		//based on the type of msg, run different method.
			}
		} else {
			if (MSG == AppConstant.PlayerMsg.PAUSE_MSG) {
				pause();
			} else if (MSG == AppConstant.PlayerMsg.STOP_MSG) {
				stop();
			}
		}

		return super.onStartCommand(intent, flags, startId);
	}

