	/**
	 * Start an activity but prompt a toast if activity is not found
	 * (instead of crashing).
	 * 
	 * @param context
	 * @param intent
	 * @param intent2 Alternative intent to call, if the first is not reachable
	 */
	public static void startSaveActivity(Context context, Intent intent, Intent intent2) {
		try {
			context.startActivity(intent);
		} catch (ActivityNotFoundException e) {
			Log.e(TAG, "Error starting activity.", e);
			try {
				context.startActivity(intent2);
			} catch (ActivityNotFoundException e2) {
				Toast.makeText(context,
						RD.string.update_error,
						Toast.LENGTH_SHORT).show();
				Log.e(TAG, "Error starting second activity.", e2);
			}
		}
	}

