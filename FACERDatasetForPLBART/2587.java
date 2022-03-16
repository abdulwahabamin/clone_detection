	public void onClick(DialogInterface dialog, int which) {
		Intent intent;
		
		if (which == BUTTON1) {
			intent = MarketUtils.getMarketDownloadIntent(mDownloadPackageName);
			startSaveActivity(intent);
    	} else if (which == BUTTON2) {
    		intent  = new Intent(Intent.ACTION_VIEW);
    		Uri uri= Uri.parse(mContext.getString(mDownloadWebsite));
			intent.setData(uri);
			startSaveActivity(intent);
    	}
	}

