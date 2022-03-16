	/**
	 * ä»ŽåŒ…ä¿¡æ?¯ä¸­èŽ·å?–ç‰ˆæœ¬å?·
	 * @param context
	 * @return
	 */
	private static int getVersionCode(Context context){
		try{
			return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
		}catch(NameNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

