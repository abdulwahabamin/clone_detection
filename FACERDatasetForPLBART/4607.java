	private void loadFileList() {
		head = (RelativeLayout) view.findViewById(R.id.files_header);
		//deleteing = (LinearLayout) view.findViewById(R.id.file_explore_archiving);
		//completed = (LinearLayout) view.findViewById(R.id.file_explore_archiving_completed);
		
		Button archivenow = (Button) view.findViewById(R.id.file_explore_archive_now);
        zipfilename = (TextView) view.findViewById(R.id.zip_file_name);
        zipfileerror = (TextView) view.findViewById(R.id.zip_error);
        zipfolder = (TextView) view.findViewById(R.id.zip_folder);
		//bButton cancel = (bButton) view.findViewById(R.id.file_explore_delete_cancel);
		//bButton safeDelete = (bButton) view.findViewById(R.id.file_explore_safe_delete_now);

        selectedFiles.clear();
        Iterator<String> it= fm.getSelectedFiles().keySet().iterator();
        while(it.hasNext()) {
            FileItem fi= fm.getSelectedFiles().get(it.next());
            if(fi!=null)
                selectedFiles.add(fi);
        }

		archivenow.setOnClickListener(archiveNowListener);

		list=(ListView) view.findViewById(R.id.archive_files_list);
		//list.setClickable(true);
		//list.setOnItemClickListener(openListener);
		//list.setOnItemLongClickListener(openLongListener);
        stopfiles = Zip.getStopZipFiles(selectedFiles);
		adapter=new FileExploreSelectedFilesAdapter(getActivity(),fm,stopfiles);
		
        list.setAdapter(adapter);

        if(zipfilename.getText().length()==0) {
            FileItem sfile=Zip.getSuggestedZipFile(selectedFiles);
            zipfilename.setText(sfile.getName().replaceAll(".zip",""));
            zipfolder.setText(sfile.getParentFile().getAbsolutePath());
        }

        if(!stopfiles.isEmpty()) {
            zipfileerror.setText(activity.getString(R.string.zip_duplicates));
            archivenow.setVisibility(View.GONE);
        } else {
            zipfileerror.setText("");
            archivenow.setVisibility(View.VISIBLE);
        }
        //BLog.e("DEL", adapter.getCount()+" files");

        //list.setEmptyView((View) activity.findViewById(R.layout.delete_files_list));

		head.setVisibility(View.VISIBLE);
		list.setVisibility(View.VISIBLE);

	}

