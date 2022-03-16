	public static void saveSharedPreferenceint(Context context,String key,int value){
		SharedPreferences sharedPreferences=context.getSharedPreferences(UtilFunctions.FileKey,MODE_PRIVATE);
		SharedPreferences.Editor editor=sharedPreferences.edit();
		editor.putInt(key,value);
		editor.commit();
	}

