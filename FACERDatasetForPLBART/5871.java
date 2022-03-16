	public boolean copyDir(File source_dir, File dest_dir)
	{
		boolean result = true;
		try
		{
			dest_dir.mkdir();
			File[] file_list = source_dir.listFiles();
			for(File source : file_list)
			{
				if(isCancelled()) break;
				if(source.canRead())
				{
					if(source.isFile())
						result = result && copyFile(
							source,
							new File(
								dest_dir,
								source.getName()
							)
						);
					else
						result = result && copyDir(
							source,
							new File(
								dest_dir,
								source.getName()
							)
						);
				}
			}
			if(move_files) return source_dir.delete();
			else return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

