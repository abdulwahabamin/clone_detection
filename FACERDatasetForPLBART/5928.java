	public void searchDirectory(File directory)
	{
		try
		{
			File[] file_list = directory.listFiles();
			for(File f : file_list)
			{
				if(isCancelled()) break;
				if(f.canRead())
				{
					if(matcher == null)
						matcher = pattern.matcher(f.getName());
					else
						matcher.reset(f.getName());

					if(matcher.find()) MainActivity.files_found.add(f);
					if(f.isDirectory()) searchDirectory(f);
				}
			}
		}
		catch(Exception e)
		{
		}
	}

