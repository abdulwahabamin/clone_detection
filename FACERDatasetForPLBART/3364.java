	public static void sendFileVia(Activity activity,File file) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file) );
		activity.startActivity(intent);
	}

