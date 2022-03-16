	public static void e(String tag, String message) {
		if(E.isDebug) {
            Log.e(tag, message);
            add(tag + " - " + message);
        }
	}

