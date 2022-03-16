	public File getDestination(File source, File dir)
	{
		String source_name = source.getName();
		File dest = new File(dir, source_name);
		while(dest.exists()) // if there is a file with this name
		{
			// try with a new name
			source_name = dest.getName();
			dest = new File(dir, copy_prefix + '_' + source_name);
		}
		return dest; // the original file or a new one
	}

