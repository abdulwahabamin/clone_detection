	private AlertDialog buildGetFromMarketDialog(int pos) {
		String this_appname = VersionUtils.getApplicationName(this);
		String info_not_available = getString(R.string.oi_distribution_info_not_available, 
				this_appname, mApplicationStrings[pos], mMinVersionName[pos]);
		String download_appname = getString(mApplications[pos]);
		
		return new DownloadAppDialog(this, 
				info_not_available, 
				download_appname, 
				mPackageNames[pos], 
				mDeveloperUris[pos]);
	}

