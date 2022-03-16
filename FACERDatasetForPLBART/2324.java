	public void onClick(DialogInterface dialog, int which) {
		final Intent intent  = new Intent(Intent.ACTION_VIEW);
		
    	if (which == BUTTON1) {
    		
    		// TODO: Obtain this resId properly from
    		// Manifest or about.xml
    		int resId = R.string.about_website_url;
    		
			intent.setData(Uri.parse(mContext.getString(resId)));
			startSaveActivity(intent);
    	} else {
    		// BUTTON2 is handled by parent.
    		super.onClick(dialog, which);
    	}
		
	}

