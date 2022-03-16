	public static void vibrate(Context context, int milliSeconds) {
		if(milliSeconds>0 && milliSeconds<2000) {
			Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
			vibrator.vibrate(milliSeconds);
		}
	}

