	public static void e(String message) {
		if(E.isDebug) {
			String callclass=Validator.callingClass();
			Log.e(Validator.callingClass(), message);
			add(callclass + " - " + message);
		}
	}

