    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_grid_view, container, false);
        mContext = getActivity().getApplicationContext();
	    mApp = (Common) mContext;
        mFragment = this;

        //Set the background color and the partial color bleed.
        mRootView.setBackgroundColor(UIElementsHelper.getBackgroundColor(mContext));

        //Grab the fragment. This will determine which data to load into the cursor.
        mFragmentId = getArguments().getInt(Common.FRAGMENT_ID);
        mFragmentTitle = getArguments().getString(MainActivity.FRAGMENT_HEADER);
        mDBColumnsMap = new HashMap<Integer, String>();
	    
        mQuickScroll = (QuickScrollGridView) mRootView.findViewById(R.id.quickscrollgrid);

		//Set the adapter for the outer gridview.
        mGridView = (GridView) mRootView.findViewById(R.id.generalGridView);
        mGridViewContainer = (RelativeLayout) mRootView.findViewById(R.id.fragment_grid_view_frontal_layout);
        mGridView.setVerticalScrollBarEnabled(false);

        //Set the number of gridview columns based on the screen density and orientation.
        if (mApp.isPhoneInLandscape() || mApp.isTabletInLandscape()) {
            mGridView.setNumColumns(4);
        } else if (mApp.isPhoneInPortrait()) {
            mGridView.setNumColumns(2);
        } else if (mApp.isTabletInPortrait()) {
            mGridView.setNumColumns(3);
        }

        //KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        	int topPadding = Common.getStatusBarHeight(mContext);
            
            //Calculate navigation bar height.
            int navigationBarHeight = 0;
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
            }

            mGridViewContainer.setPadding(0, topPadding, 0, 0);
            mGridView.setClipToPadding(false);
            mGridView.setPadding(0, mGridView.getPaddingTop(), 0, navigationBarHeight);
            mQuickScroll.setPadding(0, 0, 0, navigationBarHeight);
            
        }

        //Set the empty views.
        mEmptyTextView = (TextView) mRootView.findViewById(R.id.empty_view_text);
	    mEmptyTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Light"));
	    mEmptyTextView.setPaintFlags(mEmptyTextView.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        //Create a set of options to optimize the bitmap memory usage.
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
	    
        mHandler.postDelayed(queryRunnable, 250);
        return mRootView;
    }

