	public void startChooseFileActivity(File directory)
	{
		startActivityForResult(
			new Intent(
				null,
				Uri.fromFile(directory),
				this,
				ChooseFileActivity.class
			),
			R.id.enterfilenameactivity_browse
		);
	}

