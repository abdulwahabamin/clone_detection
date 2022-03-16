	@Override
	protected void onPause() {
		super.onPause();
		// save index and top position
        SharedPreferences prefs = getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);
		ListView lv = (ListView) findViewById(R.id.artistListView);
		int index = lv.getFirstVisiblePosition();
		View v = lv.getChildAt(0);
		int top = (v == null) ? 0 : v.getTop();
		prefs.edit().putInt("ARTIST_LIST_TOP", top).putInt("ARTIST_LIST_INDEX",index).commit();
		Log.i(TAG, "Saving position top " + top + " index " + index);
	}

