	private void loadFileList() {


		File cdir= fm.getCurrentDirectory();
		title.setText(cdir.getName());


		list.setVisibility(View.VISIBLE);
		//listImages.setVisibility(View.GONE);

		list.setClickable(true);
		//list.setOnItemClickListener(openListener);
		//list.setOnItemLongClickListener(openLongListener);
		adapter=new FileExploreAdapterZip(getActivity(),fm);
		list.setAdapter(adapter);
		list.setEmptyView(activity.getLayoutInflater().inflate(R.layout.file_explore_empty, null));
			

		setColors();


        

	}

