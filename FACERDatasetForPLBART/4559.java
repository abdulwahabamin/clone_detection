	private void loadFileList() {

		//BLog.e("loadFileList1");


		File cdir= fm.getCurrentDirectory();
		title.setText(cdir.getName());

		//BLog.e("isimages: " + fm.isCurrentDirImages());
		if(fm.isCurrentDirImages()) {
			view.setBackgroundColor(activity.getResources().getColor(R.color.black));

			list.setVisibility(View.GONE);
			listImages.setVisibility(View.VISIBLE);


			listImages.setClickable(true);
			listImages.setOnItemClickListener(openListener);
			listImages.setOnItemLongClickListener(openLongListener);
			adapterImages=new FileImagesAdapter(getActivity(),listImages,fm);
			adapterImages.setFileSelectedActionSelecter(fileSelectedActionSelecter);
			listImages.setAdapter(adapterImages);
			listImages.setEmptyView(activity.getLayoutInflater().inflate(R.layout.file_explore_empty, null));
			listImages.setOnScrollListener(this);
			//BLog.e("loadFileList.images");
			//BLog.e("CDIR", "is pictures");

		} else {
			//BLog.e("CDIR", "is files");
			view.setBackgroundColor(activity.getResources().getColor(R.color.transparent));


			list.setVisibility(View.VISIBLE);
			listImages.setVisibility(View.GONE);

			list.setClickable(true);
			list.setOnItemClickListener(openListener);
			list.setOnItemLongClickListener(openLongListener);
			adapter=new FileExploreAdapter(getActivity(),fm);
			adapter.setFileSelectedActionSelecter(fileSelectedActionSelecter);

			list.setAdapter(adapter);
			list.setEmptyView(activity.getLayoutInflater().inflate(R.layout.file_explore_empty, null));

		}
		State.updateLastKnownPosition(State.SECTION_FILE_EXPLORE,list);
		setColors();




	}

