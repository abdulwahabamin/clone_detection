	private void toggleCheckBoxVisibility(boolean visible) {
		for(IconifiedText it : mDirectoryEntries){
			it.setCheckIconVisible(visible);
		}
		
		((BaseAdapter) getListAdapter()).notifyDataSetChanged();
	}

