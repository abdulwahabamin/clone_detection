	public static void openNaverLineClientUser(Context context) {
		String appId = "jp.naver.line.android";

		  Intent intent = new Intent();
		  intent.setAction(Intent.ACTION_VIEW);
		  intent.setData(Uri.parse("line://msg/text/yui"));
		  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		  context.startActivity(intent);
	}

