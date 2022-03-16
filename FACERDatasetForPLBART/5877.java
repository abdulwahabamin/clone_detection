	public void buttonOnClick(View v)
	{
		switch(v.getId())
		{
			case R.id.enterfilenameactivity_browse:
				String s = edittext_path.getText().toString().trim();
				if(s.length() > 0)
				{
					try
					{
						File f = new File(s);
						if(f.exists())
						{
							if(f.isFile())
							{
								startChooseFileActivity( f.getParentFile() );
								break;
							}
							else if(f.isDirectory())
							{
								startChooseFileActivity(f);
								break;
							}
						}
					}
					catch(Exception e)
					{
					}
				}
				startChooseFileActivity();
				break;
			case R.id.enterfilenameactivity_do:
				buttonDoOnClick();
				break;
		}
	}

