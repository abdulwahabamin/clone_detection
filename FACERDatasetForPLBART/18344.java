	@Override
	public void onReceive(Context context, Intent intent) {
		mApp = (Common) context.getApplicationContext();

		if (mApp.isServiceRunning()) {
            Intent activityIntent = new Intent(context, NowPlayingActivity.class);
            activityIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activityIntent);

        }

	}

