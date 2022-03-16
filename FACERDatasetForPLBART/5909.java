	public void getSelectedFiles()
	{
		Map<String,String> map;
		String icon;

		selected_files.clear();
		int list_size = list_of_maps.size();
		int i = (parent_dir == null) ? 0 : 1;
		for(; i < list_size; i++)
		{
			map = list_of_maps.get(i);
			icon = map.get(ICON);
			if(icon.equals(ICON_CHECKED_FILE) || icon.equals(ICON_CHECKED_FOLDER))
				selected_files.add(list_of_files.get(i));
		}
	}

