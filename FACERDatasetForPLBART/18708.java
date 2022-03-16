    /**
     * Retrieves the folder hierarchy for the specified folder.
     *
     * @param dirPath The path of the new folder.
     * @param restoreState The state of the ListView that should be restored. Pass
     *                     null if the ListView's position should not be restored.
     */
    private void getDir(String dirPath, Parcelable restoreState) {
    	
        ((MainActivity) getActivity()).showFolderFragmentActionItems(dirPath,
                                                                     getActivity().getMenuInflater(),
                                                                     ((MainActivity) getActivity()).getMenu(),
                                                                     mIsPasteShown);

		fileFolderNameList = new ArrayList<String>();
		fileFolderPathList = new ArrayList<String>();
		fileFolderSizeList = new ArrayList<String>();
		fileFolderTypeList = new ArrayList<Integer>();
		
		File f = new File(dirPath);
		File[] files = f.listFiles();
		 
		if (files!=null) {
			
			//Sort the files by name.
			Arrays.sort(files, NameFileComparator.NAME_INSENSITIVE_COMPARATOR);
			
			for(int i=0; i < files.length; i++) {
				
				File file = files[i];
				if(file.isHidden()==SHOW_HIDDEN_FILES && file.canRead()) {
					
					if (file.isDirectory()) {

                        /*
						 * Starting with Android 4.2, /storage/emulated/legacy/...
						 * is a symlink that points to the actual directory where
						 * the user's files are stored. We need to detect the
						 * actual directory's file path here.
						 */
                        String filePath;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                            filePath = getRealFilePath(file.getAbsolutePath());
                        else
                            filePath = file.getAbsolutePath();

                        fileFolderPathList.add(filePath);
						fileFolderNameList.add(file.getName());
						File[] listOfFiles = file.listFiles();
						
						if (listOfFiles!=null) {
							fileFolderTypeList.add(FOLDER);
							if (listOfFiles.length==1) {
								fileFolderSizeList.add("" + listOfFiles.length + " item");
							} else {
								fileFolderSizeList.add("" + listOfFiles.length + " items");
							}
							
						} else {
							fileFolderTypeList.add(FOLDER);
							fileFolderSizeList.add("Unknown items");
						}
						
					} else {
						
						try {
							String path = file.getCanonicalPath();
							fileFolderPathList.add(path);
						} catch (IOException e) {
							continue;
						}
						
						fileFolderNameList.add(file.getName());
						String fileName = "";
						try {
							fileName = file.getCanonicalPath();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//Add the file element to fileFolderTypeList based on the file type.
						if (getFileExtension(fileName).equalsIgnoreCase("mp3") ||
							getFileExtension(fileName).equalsIgnoreCase("3gp") ||
							getFileExtension(fileName).equalsIgnoreCase("mp4") ||
							getFileExtension(fileName).equalsIgnoreCase("m4a") ||
							getFileExtension(fileName).equalsIgnoreCase("aac") ||
							getFileExtension(fileName).equalsIgnoreCase("ts") ||
							getFileExtension(fileName).equalsIgnoreCase("flac") ||
							getFileExtension(fileName).equalsIgnoreCase("mid") ||
							getFileExtension(fileName).equalsIgnoreCase("xmf") ||
							getFileExtension(fileName).equalsIgnoreCase("mxmf") ||
							getFileExtension(fileName).equalsIgnoreCase("midi") ||
							getFileExtension(fileName).equalsIgnoreCase("rtttl") ||
							getFileExtension(fileName).equalsIgnoreCase("rtx") ||
							getFileExtension(fileName).equalsIgnoreCase("ota") ||
							getFileExtension(fileName).equalsIgnoreCase("imy") ||
							getFileExtension(fileName).equalsIgnoreCase("ogg") ||
							getFileExtension(fileName).equalsIgnoreCase("mkv") ||
							getFileExtension(fileName).equalsIgnoreCase("wav")) {
							
							//The file is an audio file.
							fileFolderTypeList.add(AUDIO_FILE);
							fileFolderSizeList.add("" + getFormattedFileSize(file.length()));
							
						} else if (getFileExtension(fileName).equalsIgnoreCase("jpg") ||
								   getFileExtension(fileName).equalsIgnoreCase("gif") ||
								   getFileExtension(fileName).equalsIgnoreCase("png") ||
								   getFileExtension(fileName).equalsIgnoreCase("bmp") ||
								   getFileExtension(fileName).equalsIgnoreCase("webp")) {
							
							//The file is a picture file.
							fileFolderTypeList.add(PICTURE_FILE);
							fileFolderSizeList.add("" + getFormattedFileSize(file.length()));
							
						} else if (getFileExtension(fileName).equalsIgnoreCase("3gp") ||
								   getFileExtension(fileName).equalsIgnoreCase("mp4") ||
								   getFileExtension(fileName).equalsIgnoreCase("3gp") ||
								   getFileExtension(fileName).equalsIgnoreCase("ts") ||
								   getFileExtension(fileName).equalsIgnoreCase("webm") ||
								   getFileExtension(fileName).equalsIgnoreCase("mkv")) {
							
							//The file is a video file.
							fileFolderTypeList.add(VIDEO_FILE);
							fileFolderSizeList.add("" + getFormattedFileSize(file.length()));
							
						} else {
							
							//We don't have an icon for this file type so give it the generic file flag.
							fileFolderTypeList.add(FILE);
							fileFolderSizeList.add("" + getFormattedFileSize(file.length()));
							
						}

					}
					
				} 
			
			}
			
		}
		
		FoldersListViewAdapter foldersListViewAdapter = new FoldersListViewAdapter(getActivity(),
                                                                                   this,
																				   fileFolderNameList,
																				   fileFolderTypeList, 
																				   fileFolderSizeList, 
																				   fileFolderPathList);
		
		listView.setAdapter(foldersListViewAdapter);
		foldersListViewAdapter.notifyDataSetChanged();

        //Restore the ListView's previous state.
        if (restoreState!=null) {
            listView.onRestoreInstanceState(restoreState);
        } else if (mFolderStateMap.containsKey(dirPath)) {
            listView.onRestoreInstanceState(mFolderStateMap.get(dirPath));
        }

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {

                //Store the current folder's state in the HashMap.
                if (mFolderStateMap.size()==3) {
                    mFolderStateMap.clear();
                }

                mFolderStateMap.put(currentDir, listView.onSaveInstanceState());

                String newPath = fileFolderPathList.get(index);
                if ((Integer) view.getTag(R.string.folder_list_item_type)==FOLDER)
                    currentDir = newPath;

                //Check if the selected item is a folder or a file.
                if (fileFolderTypeList.get(index)==FOLDER) {
                    getDir(newPath, null);
                } else {
                    int fileIndex = 0;
                    for (int i=0; i < index; i++) {
                        if (fileFolderTypeList.get(i)==AUDIO_FILE)
                            fileIndex++;
                    }

                    play(fileFolderTypeList.get(index), fileIndex, currentDir);
                }

            }

        });
		
    }

