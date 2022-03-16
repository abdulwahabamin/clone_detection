	public boolean deleteFile(File f)
	{
		try
		{
			return f.delete();
		}
		catch(Exception e)
		{
			return false;
		}
	}

