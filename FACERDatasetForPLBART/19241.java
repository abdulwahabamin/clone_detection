	/**
	 * Retrieves the folder hierarchy for the specified folder 
	 * (this method is NOT recursive and doesn't go into the parent 
	 * folder's subfolders. 
	 */
    private void getDir(String dirPath) {

		mFileFolderNamesList = new ArrayList<String>();
		mFileFolderPathsList = new ArrayList<String>();
		mFileFolderSizesList = new ArrayList<String>();
		
		File f = new File(dirPath);
		File[] files = f.listFiles();
		Arrays.sort(files);
		 
		if (files!=null) {
			
			for(int i=0; i < files.length; i++) {
				
				File file = files[i];
			 
				if(!file.isHidden() && file.canRead()) {
					
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
							
						mFileFolderPathsList.add(filePath);
						mFileFolderNamesList.add(file.getName());
						
						File[] listOfFiles = file.listFiles();
						
						if (listOfFiles!=null) {
							if (listOfFiles.length==1) {
								mFileFolderSizesList.add("" + listOfFiles.length + " item");
							} else {
								mFileFolderSizesList.add("" + listOfFiles.length + " items");
							}
							
						}
						
					}
					
				} 
			
			}
			
		}
		
		boolean dirChecked = false;
		if (getMusicFoldersHashMap().get(dirPath)!=null)
			dirChecked = getMusicFoldersHashMap().get(dirPath);
		
		MultiselectListViewAdapter mFoldersListViewAdapter = new MultiselectListViewAdapter(getActivity(), 
																							this, 
																							mWelcomeSetup,
																							dirChecked);
		
		mFoldersListView.setAdapter(mFoldersListViewAdapter);
		mFoldersListViewAdapter.notifyDataSetChanged();

        mCurrentDir = dirPath;
        setCurrentDirText();
		
    }

