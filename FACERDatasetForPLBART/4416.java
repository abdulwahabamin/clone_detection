	private static void openAndroidBrowserUrlPost(Context context, String url, String data) {
		Intent i = new Intent();
		// MUST instantiate android browser, otherwise it won't work (it won't find an activity to satisfy intent)
		i.setComponent(new ComponentName("com.android.browser", "com.android.browser.BrowserActivity"));
		i.setAction(Intent.ACTION_VIEW);
		String html = Files.readTrimRawTextFile(context, R.raw.crashreport);

		// Replace params (if any replacement needed)

		// May work without url encoding, but I think is advisable
		// URLEncoder.encode replace space with "+", must replace again with %20
		String dataUri = "data:text/html," + URLEncoder.encode(html).replaceAll("\\+","%20");
		i.setData(Uri.parse(dataUri));
		context.startActivity(i);
	}

