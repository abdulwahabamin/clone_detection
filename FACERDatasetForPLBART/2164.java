	public AboutDialog(Context context) {
		super(context,
				R.string.oi_distribution_aboutapp_not_available,
				R.string.oi_distribution_aboutapp,
				R.string.oi_distribution_aboutapp_package,
				R.string.oi_distribution_aboutapp_website);

		String version = VersionUtils.getVersionNumber(mContext);
        String appname = VersionUtils.getApplicationName(mContext);
        String appnameversion = mContext.getString(R.string.oi_distribution_name_and_version, appname, version);
        
        StringBuilder sb = new StringBuilder();
        sb.append(appnameversion);
        sb.append("\n\n");
        sb.append(mMessageText);
        setMessage(sb.toString());
	}

