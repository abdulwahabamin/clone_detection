    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_list_view, container, false);
        mContext = getActivity().getApplicationContext();
	    mApp = (Common) mContext;
        mFragment = this;
        
        //Set the background. We're using getGridViewBackground() since the list doesn't have card items.
        mRootView.setBackgroundColor(UIElementsHelper.getGridViewBackground(mContext));
        
        //Grab the fragment. This will determine which data to load into the cursor.
        mFragmentId = getArguments().getInt(Common.FRAGMENT_ID);
        mFragmentTitle = getArguments().getString(MainActivity.FRAGMENT_HEADER);
        mDBColumnsMap = new HashMap<Integer, String>();
        
	    //Init the search fields.
	    mSearchLayout = (RelativeLayout) mRootView.findViewById(R.id.search_layout);
	    mSearchEditText = (EditText) mRootView.findViewById(R.id.search_field);
	    
	    mSearchEditText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
	    mSearchEditText.setPaintFlags(mSearchEditText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
	    mSearchEditText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
	    mSearchEditText.setFocusable(true);
	    mSearchEditText.setCursorVisible(true);
	    
        mQuickScroll = (QuickScroll) mRootView.findViewById(R.id.quickscroll);

	    mListView = (ListView) mRootView.findViewById(R.id.generalListView);
        mListView.setVerticalScrollBarEnabled(false);

        //Apply the ListViews' dividers.
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            mListView.setDivider(mContext.getResources().getDrawable(R.drawable.icon_list_divider));
        } else {
            mListView.setDivider(mContext.getResources().getDrawable(R.drawable.icon_list_divider_light));
        }

		mListView.setDividerHeight(1);
        
        //KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        	int topPadding = Common.getStatusBarHeight(mContext);
            
            //Calculate navigation bar height.
            int navigationBarHeight = 0;
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
            
            mListView.setClipToPadding(false);
            mListView.setPadding(0, topPadding, 0, navigationBarHeight);
            mQuickScroll.setPadding(0, topPadding, 0, navigationBarHeight);

            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mListView.getLayoutParams();
            layoutParams = (RelativeLayout.LayoutParams) mSearchLayout.getLayoutParams();
            layoutParams.setMargins(15, topPadding + 15, 15, 0);
            mSearchLayout.setLayoutParams(layoutParams);
            
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
	    
        mHandler.postDelayed(queryRunnable, 400);
        return mRootView;
    }

