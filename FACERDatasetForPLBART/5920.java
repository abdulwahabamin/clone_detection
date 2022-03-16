	public void buttonDoOnClick()
	{
		String s = edittext_path.getText().toString().trim();
		if(s.length() > 0)
		{
			try
			{
				file = new File(s);
				if(file.exists())
				{
					if( file.isFile() )
					{
						if( file.canWrite() ) showDialog(R.string.file_already_exists);
						else throw new Exception( getString(R.string.you_cannot_modify_the_file) );
					}
					else throw new Exception( getString(R.string.is_not_file) );
				}
				else
				{
					if( file.createNewFile() ) returnFile(file);
					else throw new Exception( getString(R.string.cannot_create_file) );
				}
			}
			catch(Exception e)
			{
				edittext_path.setError( e.getMessage() );
			}
		}
	}

