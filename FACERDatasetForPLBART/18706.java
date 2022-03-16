    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_folders, container, false);
        mContext = getActivity().getApplicationContext();
        mFilesFoldersFragment = this;
        mApp = (Common) mContext;
        mFolderStateMap = new HashMap<String, Parcelable>();
        
        //Set the hidden files flag.
        SHOW_HIDDEN_FILES = mApp.getSharedPreferences().getBoolean("SHOW_HIDDEN_FILES", false);

        listView = (ListView) rootView.findViewById(R.id.folders_list_view);
        listView.setFastScrollEnabled(true);
        listView.setVisibility(View.INVISIBLE);
        
		//Set the background color based on the theme.
        rootView.setBackgroundColor(UIElementsHelper.getBackgroundColor(mContext));

        //Apply the ListView params.
        //Apply the ListViews' dividers.
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            listView.setDivider(mContext.getResources().getDrawable(R.drawable.icon_list_divider));
        } else {
            listView.setDivider(mContext.getResources().getDrawable(R.drawable.icon_list_divider_light));
        }

        listView.setDividerHeight(1);

		//KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT==Build.VERSION_CODES.KITKAT) {
        	int topPadding = Common.getStatusBarHeight(mContext);

            //Calculate navigation bar height.
            int navigationBarHeight = 0;
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
            
            if (rootView!=null) {
            	rootView.setPadding(0, topPadding, 0, 0);
            }
            
            listView.setClipToPadding(false);
            listView.setPadding(0, 0, 0, navigationBarHeight);
        }

        rootDir = mApp.getSharedPreferences().getString("DEFAULT_FOLDER", Environment.getExternalStorageDirectory().getPath());
        currentDir = rootDir;
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                slideUpListView();
            }

        }, 250);
        return rootView;
    }

