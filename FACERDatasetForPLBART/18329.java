	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.blacklist_manager, menu);
	    
	    ActionBar actionBar = getActionBar();
	    actionBar.setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));
		SpannableString s = new SpannableString(getResources().getString(R.string.blacklist_manager));
	    s.setSpan(new TypefaceSpan(this, "RobotoCondensed-Light"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    actionBar.setTitle(s);
	    
		return super.onCreateOptionsMenu(menu);
	}

