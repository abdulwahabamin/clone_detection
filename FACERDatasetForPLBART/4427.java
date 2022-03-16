	public static void openGmailClient(Context context, String email,String subject) {
		Intent sendIntent = new Intent(Intent.ACTION_VIEW);
		sendIntent.setType("plain/text");
		sendIntent.setData(Uri.parse(email));
		sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
		if(subject!=null) {
			sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		}
		sendIntent.putExtra(Intent.EXTRA_TEXT, "\n\n\n\n\n\n\nSent via Brief.ink");
		sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(sendIntent);
	}

