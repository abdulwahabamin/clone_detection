	public Boolean doInBackground(Void... params)
	{
		boolean result = true;
		for(File f : files_to_delete)
		{
			if(isCancelled()) break;
			if(f.isFile()) result = result && deleteFile(f);
			else result = result && deleteDir(f);
		}
		return result;
	}

