	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		MP3Info info=(MP3Info)intent.getSerializableExtra("mp3info");
		int MSG=intent.getIntExtra("MSG", 0);
		if(info!=null){
			//------------------------------------------
		}
		
		
		return super.onStartCommand(intent, flags, startId);
	}

