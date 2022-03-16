	private void processFile(Uri uri){
		fileScheme = true;
		Intent intent = createPickIntent();
		intent.setData(uri);
		startPickActivity(intent);
	}

