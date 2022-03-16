	public void selectAll(boolean invertSelection)
	{
		int list_size = list_of_maps.size();
		int i = (parent_dir == null) ? 0 : 1;
		for(; i < list_size; i++)
		{
			selectItem(list_of_maps.get(i), invertSelection);
		}
		simple_adapter.notifyDataSetChanged();
	}

