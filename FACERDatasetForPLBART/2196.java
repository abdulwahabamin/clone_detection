	protected void set(String message, String download_name,
			String download_package, String download_website) {
        mDownloadAppName = download_name;
        mDownloadPackageName = download_package;
        mDownloadWebsite = download_website;
        
        mMarketAvailable = MarketUtils.isMarketAvailable(mContext, mDownloadPackageName);
        
        StringBuilder sb = new StringBuilder();
        sb.append(message);
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

