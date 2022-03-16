	private void loadFileList() {

		File cdir= fm.getCurrentDirectory();
		title.setText(cdir.getName());
		//BLog.e("CDIR", "is files");
		view.setBackgroundColor(activity.getResources().getColor(R.color.transparent));


		list.setVisibility(View.VISIBLE);

		list.setClickable(true);
		list.setOnItemClickListener(openListener);
		adapter=new FolderChooseAdapter(getActivity(),fm);


		list.setAdapter(adapter);
		list.setEmptyView(activity.getLayoutInflater().inflate(R.layout.file_explore_empty,null));





	}

