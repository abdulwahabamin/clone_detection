	public void goToItem(File f)
	{
		int list_size = list_of_maps.size();
		int i = (parent_dir == null) ? 0 : 1;
		for(; i < list_size; i++)
		{
			if(list_of_files.get(i).equals(f))
			{
				setSelection(i);
				break;
			}
		}
	}

