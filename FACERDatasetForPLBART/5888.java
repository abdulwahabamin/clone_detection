	public void addListItem(String icon, String name, String size_string, String date_string)
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put(ICON, icon);
		map.put(NAME, name);
		map.put(SIZE, size_string);
		map.put(DATE, date_string);
		list_of_maps.add(map);
	}

