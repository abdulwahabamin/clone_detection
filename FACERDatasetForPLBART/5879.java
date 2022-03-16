	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch(requestCode)
		{
			case R.id.enterfilenameactivity_browse:
				if(resultCode == RESULT_OK)
				{
					edittext_path.setText( data.getData().getPath() );
				}
				break;
		}
	}

