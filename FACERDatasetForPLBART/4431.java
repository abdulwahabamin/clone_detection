	public static void openNaverLineClient(Context context, String phonenumber) {
		
		Intent sendIntent = new Intent(Intent.ACTION_SEND);
		sendIntent.setType("plain/text");
		sendIntent.setData(Uri.parse("tel:" + phonenumber));
		sendIntent.setClassName(PACKAGE_NAME, CLASS_NAME);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "");
		sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(sendIntent);
	}

