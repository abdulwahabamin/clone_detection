	public static void openNaverLineClientVideo(Context context, File videoFile) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setClassName(PACKAGE_NAME, CLASS_NAME);
		intent.setType("video/mp4");
		intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(videoFile.getPath()));
		//intent.putExtra(Intent.EXTRA_STREAM, 影片路徑);
		intent.putExtra(Intent.EXTRA_TEXT, "Enjoy the Video");
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

