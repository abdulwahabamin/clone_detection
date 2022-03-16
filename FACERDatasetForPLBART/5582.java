	public DownloadOIAppDialog(Context context, int appId) {
		super(context);
		
		switch(appId) {
		case OI_BARCODESCANNER:
			set(R.string.oi_distribution_barcodescanner_not_available,
			R.string.oi_distribution_barcodescanner,
			R.string.oi_distribution_barcodescanner_package,
			R.string.oi_distribution_barcodescanner_website);
			break;
		case OI_FILEMANAGER:
			set(R.string.oi_distribution_filemanager_not_available,
			R.string.oi_distribution_filemanager,
			R.string.oi_distribution_filemanager_package,
			R.string.oi_distribution_filemanager_website);
			break;
		case OI_SAFE:
			set(R.string.oi_distribution_safe_not_available,
			R.string.oi_distribution_safe,
			R.string.oi_distribution_safe_package,
			R.string.oi_distribution_safe_website);
			break;
		}
	}

