	public void startChooseFileActivity()
	{
		startActivityForResult(
			new Intent(this, ChooseFileActivity.class),
			R.id.enterfilenameactivity_browse
		);
	}

