	private void processContent(Uri uri){
		fileScheme = false;
		String name = getPath(uri);
		Intent intent = createPickIntent();
		intent.setData(Uri.parse(name));
		startPickActivity(intent);
	}

