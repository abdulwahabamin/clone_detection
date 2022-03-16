	public static void saveSharedPreferencestring(Context context,String key,String value){
		SharedPreferences sharedPreferences=context.getSharedPreferences(UtilFunctions.FileKey,MODE_PRIVATE);
		SharedPreferences.Editor editor=sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

