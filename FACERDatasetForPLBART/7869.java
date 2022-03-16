	@Override
    protected void onPause() {
        super.onPause();
        Log.v( TAG, "onPause()" );
        toLog();
        SharedPreferences.Editor sp_edit = PreferenceManager.getDefaultSharedPreferences( this ).edit();
        array.store( sp_edit );
        sp_edit.commit();
	}

