	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.add_to_music_library, menu);
	    
	    ActionBar actionBar = getActionBar();
	    actionBar.setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));
		actionBar.setIcon(mContext.getResources().getIdentifier(libraryIconName, "drawable", mContext.getPackageName()));
		SpannableString s = new SpannableString(libraryName);
	    s.setSpan(new TypefaceSpan(this, "RobotoCondensed-Light"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    actionBar.setTitle(s);
	    
		return super.onCreateOptionsMenu(menu);
	}

