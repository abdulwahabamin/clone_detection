	public void buttonDoOnClick()
	{
		String s = edittext_path.getText().toString().trim();
		if(s.length() > 0)
		{
			try
			{
				File f = new File(s);
				if(f.exists())
				{
					if( f.isFile() )
					{
						if( f.canRead() ) returnFile(f);
						else throw new Exception( getString(R.string.you_cannot_read_the_file) );
					}
					else throw new Exception( getString(R.string.is_not_file) );
				}
				else
				{
					if( f.createNewFile() ) returnFile(f);
					else throw new Exception( getString(R.string.cannot_create_file) );
				}
			}
			catch(Exception e)
			{
				edittext_path.setError( e.getMessage() );
			}
		}
	}

