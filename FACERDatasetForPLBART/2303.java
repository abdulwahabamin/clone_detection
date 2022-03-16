    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDistribution.setFirst(MENU_DISTRIBUTION_START, DIALOG_DISTRIBUTION_START);
        
        // Check whether EULA has been accepted
        // or information about new version can be presented.
        if (mDistribution.showEulaOrNewVersion()) {
            return;
        }
        
        setContentView(R.layout.oi_distribution_infoactivity);

        init();
        
        mApplicationStrings = new String[mApplications.length];
        for (int i = 0; i < mApplications.length; i++) {
        	mApplicationStrings[i] = getString(mApplications[i]);
        }
        setListAdapter(new FontArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mApplicationStrings));
        ListView listview = getListView();
        
        listview.setOnItemClickListener(this);
        
        // Set message of activity
        String appname = VersionUtils.getApplicationName(this);
		String message = getString(R.string.oi_distribution_info_activity_text, 
				appname);
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(message);
        
        /*
        TypedArray a = obtainStyledAttributes(mTheme, R.styleable.ShoppingList);
		String typefaceName = a.getString(R.styleable.ShoppingList_textTypeface);
	    mTextSizeMedium = a.getDimensionPixelOffset(R.styleable.ShoppingList_textSizeMedium, 23);
	    mTextSizeLarge = a.getDimensionPixelOffset(R.styleable.ShoppingList_textSizeLarge, 28);
	    mTextColor = a.getColor(R.styleable.ShoppingList_textColor, Color.BLACK);
	    Drawable background = a.getDrawable(R.styleable.ShoppingList_background);

	    
	    View v = findViewById(R.id.background);
	    v.setBackgroundDrawable(background);
	    
		mTypeface = Typeface.createFromAsset(getResources().getAssets(), typefaceName);
        
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setTypeface(mTypeface);
        tv.setTextSize(mTextSizeMedium);
        tv.setTextColor(mTextColor);
	    */
    }

