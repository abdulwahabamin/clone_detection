    public AsyncDeleteAlbumArtTask(Context context, View viewItem, int imageID, Activity activity, String callingFragment) {
    	mContext = context;
    	mApp = (Common) mContext.getApplicationContext();
    	mViewItem = viewItem;
    	mImageID = imageID;
    	mActivity = activity;
    	mCallingFragment = callingFragment;
    }

