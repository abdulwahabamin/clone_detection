	protected void set(int message, int download_name,
			int download_package, int download_website) {
		mDownloadPackage = download_package;
        mDownloadWebsite = download_website;

        mDownloadAppName = mContext.getString(download_name);
        mDownloadPackageName = mContext.getString(mDownloadPackage);
        
        mMarketAvailable = MarketUtils.isMarketAvailable(mContext, mDownloadPackageName);
        
        StringBuilder sb = new StringBuilder();
        sb.append(mContext.getString(message));
        sb.append(" ");
        if (mMarketAvailable) {
        	sb.append(mContext.getString(R.string.oi_distribution_download_market_message, 
        			mDownloadAppName));
        } else {
        	sb.append(mContext.getString(R.string.oi_distribution_download_message, 
        			mDownloadAppName));
        }
        mMessageText = sb.toString();
        setMessage(mMessageText);

        setTitle(mContext.getString(R.string.oi_distribution_download_title,
        		mDownloadAppName));
        
        setButton(mContext.getText(R.string.oi_distribution_download_market), this);
    	setButton2(mContext.getText(R.string.oi_distribution_download_web), this);
	}

