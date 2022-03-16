	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//according to the position the user clicked, we can get the the corresponding mps info.
		MP3Info info=mp3Infos.get(position);
		
		Intent intent=new Intent();
		//put mp3 info object into the intent object.
		intent.putExtra("mp3info", info);
		intent.setClass(this, DownloadService.class);
		startService(intent);
	}

