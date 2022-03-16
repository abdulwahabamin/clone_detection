	/**
	 * 返回市场，如果获�?�失败返回defaultChannel
	 * @param context
	 * @param defaultChannel
	 * @return
	 */
	public static String getChannel(Context context, String defaultChannel) {
		//内存中获�?�
		if(!TextUtils.isEmpty(mChannel)){
			return mChannel;
		}
		//sp中获�?�
		mChannel = getChannelBySharedPreferences(context);
		if(!TextUtils.isEmpty(mChannel)){
			return mChannel;
		}
		//从apk中获�?�
		mChannel = getChannelFromApk(context, CHANNEL_KEY);
		if(!TextUtils.isEmpty(mChannel)){
			//�?存sp中备用
			saveChannelBySharedPreferences(context, mChannel);
			return mChannel;
		}
		//全部获�?�失败
		return defaultChannel;
    }

