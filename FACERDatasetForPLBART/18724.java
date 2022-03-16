    public FoldersListViewAdapter(Context context,
                                  FilesFoldersFragment fragment,
    							  List<String> nameList, 
    							  List<Integer> fileFolderTypeList,
    							  List<String> sizeList, 
    							  List<String> fileFolderPathsList) {
    	
    	super(context, -1, nameList);
    	
    	mContext = context;
        mApp = (Common) mContext.getApplicationContext();
        mFragment = fragment;

    	mFileFolderNameList = nameList;
    	mFileFolderTypeList = fileFolderTypeList;
    	mFileFolderSizeList = sizeList;
    	mFileFolderPathsList = fileFolderPathsList;
    	
    }

