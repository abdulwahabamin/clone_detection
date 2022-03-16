    public NavigationDrawerAdapter(Context context, ArrayList<String> titlesList) {
    	super(context, R.layout.sliding_menu_browsers_layout, titlesList);
    	mContext = context;
    	mTitlesList = titlesList;
    	sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
    }

