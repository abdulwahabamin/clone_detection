    public GridViewCardsAdapter(Context context, GridViewFragment gridViewFragment,
                                HashMap<Integer, String> dbColumnsMap) {
    	
        super(context, -1, gridViewFragment.getCursor(), new String[] {}, new int[] {}, 0);
        mContext = context;
        mGridViewFragment = gridViewFragment;
        mApp = (Common) mContext.getApplicationContext();
        mDBColumnsMap = dbColumnsMap;

        //Calculate the height and width of each item image.
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();

        if (mApp.isTabletInPortrait()) {
            //3 column layout.
            mWidth = (metrics.widthPixels)/3;
            mHeight = mWidth + (mWidth/4);
        } else if (mApp.isPhoneInLandscape() || mApp.isTabletInLandscape()) {
            //4 column layout.
            mWidth = (metrics.widthPixels)/4;
            mHeight = mWidth + (mWidth/5);
        } else {
            //2 column layout.
            mWidth = (metrics.widthPixels)/2;
            mHeight = mWidth + (mWidth/3);
        }

    }

