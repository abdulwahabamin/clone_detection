	public AboutDialog(Context context) {
		super(context,
				RD.string.aboutapp_not_available,
				RD.string.aboutapp_get,
				RD.string.aboutapp_market_uri,
				RD.string.aboutapp_developer_uri);
		
		String version = VersionUtils.getVersionNumber(context);
		String name = VersionUtils.getApplicationName(context);

		setTitle(name);
		setMessage(context.getString(RD.string.aboutapp_not_available, version));
	}

