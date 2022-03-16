	public void onClick(DialogInterface dialog, int which) {
    	if (which == BUTTON1) {
    		Uri uri = Uri.parse(mContext.getString(mMarketUri));
    		
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(uri);

			uri= Uri.parse(mContext.getString(mDeveloperUri));
			Intent intent2 = new Intent(Intent.ACTION_VIEW);
			intent2.setData(uri);
			startSaveActivity(mContext, intent, intent2);
    	}
		
	}

