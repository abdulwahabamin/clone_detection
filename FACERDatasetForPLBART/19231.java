	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_trial_version, container, false);
		mContext = getActivity().getApplicationContext();
		sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		
		numDaysRemaining = getArguments().getInt("NUM_DAYS_REMAINING");
		expired = getArguments().getBoolean("EXPIRED");

        //Circumvent the trial check since the app is no longer paid.
        getActivity().finish();
        Intent intent = new Intent(mContext, MainActivity.class);
        startActivity(intent);
        return rootView;

		/*daysRemaining = (TextView) rootView.findViewById(R.id.trial_days_remaining);
		infoText = (TextView) rootView.findViewById(R.id.trial_message);
		laterButton = (Button) rootView.findViewById(R.id.upgrade_later);
		upgradeNowButton = (Button) rootView.findViewById(R.id.upgrade_now);
		
		daysRemaining.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		daysRemaining.setPaintFlags(daysRemaining.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		infoText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		infoText.setPaintFlags(infoText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		laterButton.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		laterButton.setPaintFlags(laterButton.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		upgradeNowButton.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		upgradeNowButton.setPaintFlags(upgradeNowButton.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		if (expired) {
			daysRemaining.setText(R.string.expired);
			infoText.setText(R.string.trial_expired);
			daysRemaining.setTextColor(0xFFCC0000);
		} else {
			infoText.setText(R.string.trial_running);
			if (numDaysRemaining==1) {
				daysRemaining.setText(numDaysRemaining + " " + mContext.getResources().getString(R.string.day_remaining));
			} else {
				daysRemaining.setText(numDaysRemaining + " " + mContext.getResources().getString(R.string.days_remaining));
			}
			
			daysRemaining.setTextColor(0xFF0099CC);
		}
		
		laterButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (expired) {
					getActivity().finish();
				} else {
					launchMainActivity();
				}
				
			}
			
		});
		
		upgradeNowButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				initUpgradeProcessWithPromo();
				
			}
			
		});
		
		//KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        	int topPadding = Common.getStatusBarHeight(mContext);

        	//Calculate ActionBar height
            TypedValue tv = new TypedValue();
            int actionBarHeight = 0;
            if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
            }
        	
            //Calculate navigation bar height.
            int navigationBarHeight = 0;
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
            
            rootView.setClipToPadding(false);
            rootView.setPadding(0, topPadding + actionBarHeight, 0, navigationBarHeight);
        }
		
		return rootView;*/
	}

