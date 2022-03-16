	public static void onPrepareDialog(Context context, Dialog dialog) {
		DownloadAppDialog d = (DownloadAppDialog) dialog;
		
		boolean has_android_market = MarketUtils.isMarketAvailable(context, d.mDownloadPackageName);

		dialog.findViewById(android.R.id.button1).setVisibility(
				has_android_market ? View.VISIBLE : View.GONE);
	}

