	protected void set(int message_id, int download_name_id,
			int download_package_id, int download_website_id) {
		String message = mContext.getString(message_id);
		String download_name = mContext.getString(download_name_id);
		String download_package = mContext.getString(download_package_id);
		String download_website = mContext.getString(download_website_id);
		set(message, download_name, download_package, download_website);
	}

