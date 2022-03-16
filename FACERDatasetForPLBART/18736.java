	public static GMusicClientCalls getInstance(Context context) {
		if(mInstance == null)
			mInstance = new GMusicClientCalls(context);
		
		return mInstance;
	}

