	private GMusicClientCalls(Context context) {
		mHttpClient = new GMusicHttpClient();
		mContext = context;
		mCookieStore = new PersistentCookieStore(context.getApplicationContext());
		mHttpClient.setCookieStore(mCookieStore);
		mHttpClient.setUserAgent("");
	}

