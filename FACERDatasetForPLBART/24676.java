	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		//get info from the intent
		MP3Info info=(MP3Info)intent.getSerializableExtra("mp3info");
		
		//create a thread and pass the info object into the thread
		Thread thread=new Thread(new DownloadThread(info));
		thread.start();
		return super.onStartCommand(intent, flags, startId);
	}

