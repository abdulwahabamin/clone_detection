	public boolean isEqualOrInside(File dir1, File dir2)
	{
		do
		{
			if(dir1.equals(dir2)) return true;
			else dir1 = dir1.getParentFile();
		}
		while(dir1 != null); // up to the root
		return false;
	}

