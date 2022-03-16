	/**
	 * Fix for KitKat error where the service is killed as soon 
	 * as the app is swiped away from the Recents menu.
	 */
	@Override
	public void onTaskRemoved(Intent rootIntent) {
	   Intent intent = new Intent(this, KitKatFixActivity.class);
	   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	   startActivity(intent);
	   
	}

