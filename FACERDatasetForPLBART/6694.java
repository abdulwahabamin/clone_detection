   private void toggleSelection(boolean selected) {
	   for(IconifiedText it : mDirectoryEntries){
		   it.setSelected(selected);
	   }
	   
	   ((BaseAdapter) getListAdapter()).notifyDataSetChanged();
   }

