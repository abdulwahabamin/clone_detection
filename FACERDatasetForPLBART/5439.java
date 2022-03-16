	/**
	 * Shows dialog box with option to upgrade.
	 * 
	 * @param context
	 */
	public static void showUpdateBox(final Context context) {
		String version = null;
		try {
			version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		final Intent intent  = new Intent(Intent.ACTION_VIEW);
		final Intent intent2  = new Intent(Intent.ACTION_VIEW);
		new Builder(context).setMessage(context.getString(RD.string.update_box_text, version))
		.setPositiveButton(RD.string.update_check_now, new OnClickListener(){

			public void onClick(DialogInterface arg0, int arg1) {
				intent.setData(Uri.parse(context.getString(RD.string.update_app_url)));
				intent2.setData(Uri.parse(context.getString(RD.string.update_app_developer_url)));
				GetFromMarketDialog.startSaveActivity(context, intent, intent2);
			}
			
		}).setNegativeButton(RD.string.update_get_updater, new OnClickListener(){

			public void onClick(DialogInterface dialog, int which) {
				intent.setData(Uri.parse(context.getString(RD.string.update_checker_url)));
				intent2.setData(Uri.parse(context.getString(RD.string.update_checker_developer_url)));
				GetFromMarketDialog.startSaveActivity(context, intent, intent2);
			}
			
		}).show();		
	}

