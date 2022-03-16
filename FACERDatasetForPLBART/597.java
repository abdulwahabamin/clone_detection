	/**
	 * 从sp中获�?�channel
	 * @param context
	 * @return 为空表示获�?�异常�?sp中的值已�?失效�?sp中没有此值
	 */
	private static String getChannelBySharedPreferences(Context context){
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
		int currentVersionCode = getVersionCode(context);
		if(currentVersionCode == -1){
			//获�?�错误
			return "";
		}
		int versionCodeSaved = sp.getInt(CHANNEL_VERSION_KEY, -1);
		if(versionCodeSaved == -1){
			//本地没有存储的channel对应的版本�?�
			//第一次使用或者原先存储版本�?�异常
			return "";
		}
		if(currentVersionCode != versionCodeSaved){
			return "";
		}
		return sp.getString(CHANNEL_KEY, "");
	}

