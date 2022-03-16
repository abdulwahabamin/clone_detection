	public static void showDialogOrStartActivity(Activity activity, int dialogId) {
		Intent intent = new Intent(AboutMiniIntents.ACTION_SHOW_ABOUT_DIALOG);
		intent.putExtra(AboutMiniIntents.EXTRA_PACKAGE_NAME, activity.getPackageName());
		
		if (IntentUtils.isIntentAvailable(activity, intent)) {
			activity.startActivity(intent);
		} else {
			activity.showDialog(dialogId);
		}
	}

