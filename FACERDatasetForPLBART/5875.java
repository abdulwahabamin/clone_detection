	public boolean deleteDir(File dir)
	{
		boolean result = true;
		try
		{
			for(File f : dir.listFiles())
			{
				if(isCancelled()) break;
				if(f.isFile()) result = result && deleteFile(f);
				else result = result && deleteDir(f);
			}
			return dir.delete();
		}
		catch(Exception e)
		{
			return false;
		}
	}

