    public AsyncIterateThruFolderTask(Context context, 
    								  boolean firstRun, 
    								  ArrayList<String> tempSelectedFolderPaths, 
    								  ArrayList<String> tempSelectedFolderTimestamps,
    								  String parentPath, 
    								  String operation) {
    	mContext = context;
    	mFirstRun = firstRun;
    	mOperation = operation;
    	mParentPath = parentPath;
    	mTempSelectedFolderPaths = tempSelectedFolderPaths;
    	mTempSelectedFolderTimestamps = tempSelectedFolderTimestamps;
    	
    	//Get the name of the folder that's being iterated through.
    	int index = mParentPath.lastIndexOf("/");
    	mFolderName = mParentPath.substring((index+1), (mParentPath.length()));
    	
    }

