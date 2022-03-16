    public AsyncCopyMoveTask(Context context,
                             File sourceFile,
                             File destinationFile,
                             FilesFoldersFragment fragment,
                             boolean shouldMove) {
    	
    	mContext = context;
    	mSourceFile = sourceFile;
        mFragment = fragment;
    	mDestinationFile = destinationFile;
        mShouldMove = shouldMove;
    }

