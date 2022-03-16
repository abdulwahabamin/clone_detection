	public Boolean doInBackground(Void... params)
	{
		boolean result = true;
		for(File f : files_to_copy)
		{
			if(isCancelled()) break;
			if(f.isFile())
				result = result && copyFile(
					f,
					getDestination(f, destination_dir)
				);
			else
			{
				if(isEqualOrInside(destination_dir, f))
					result = false; // cannot copy a directory tree inside itself
				else
					result = result && copyDir(
						f,
						getDestination(f, destination_dir)
					);
			}
		}
		return result;
	}

