	@Override
	public void onReceive(Context context, Intent intent) {
		
		//Stop the service.
		Common app = (Common) context.getApplicationContext();
		app.getService().stopSelf();
		
	}

