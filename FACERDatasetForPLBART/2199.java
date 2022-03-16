	/**
	 * Start an activity but prompt a toast if activity is not found
	 * (instead of crashing).
	 * 
	 * @param context
	 * @param intent
	 */
	public void startSaveActivity(Intent intent) {
		try {
			mContext.startActivity(intent);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(mContext,
					R.string.oi_distribution_update_error,
					Toast.LENGTH_SHORT).show();
			Log.e(TAG, "Error starting second activity.", e);
		}
	}

