	public void refreshData() {
		

        deletenow.setOnClickListener(deleteNowListener);


		list=(ListView) view.findViewById(R.id.delete_files_list);
		//list.setClickable(true);
		//list.setOnItemClickListener(openListener);
		//list.setOnItemLongClickListener(openLongListener); 
		adapter=new FileExploreSelectedFilesAdapter(getActivity(),fm);
		
        list.setAdapter(adapter);
        
        //BLog.e("DEL", adapter.getCount()+" files");

        //list.setEmptyView((View) activity.findViewById(R.layout.file_explore_empty));

		head.setVisibility(View.VISIBLE);
		list.setVisibility(View.VISIBLE);
		//upgrade.setVisibility(View.GONE);
		deleteing.setVisibility(View.GONE);
		completed.setVisibility(View.GONE);
	}

