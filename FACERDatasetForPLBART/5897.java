	public void selectItem(Map<String,String> map, boolean invertSelection)
	{
		String icon = map.get(ICON);
		if(icon.equals(ICON_CHECKED_FILE))
		{
			if(invertSelection) icon = ICON_UNCHECKED_FILE;
		}
		else if(icon.equals(ICON_CHECKED_FOLDER))
		{
			if(invertSelection) icon = ICON_UNCHECKED_FOLDER;
		}
		else if(icon.equals(ICON_UNCHECKED_FILE))
			icon = ICON_CHECKED_FILE;
		else
			icon = ICON_CHECKED_FOLDER;

		map.put(ICON, icon);
	}

