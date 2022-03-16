	private void sendFile(File file) {

		String filename = file.getName();
		String content = "hh";
		
		Log.i(TAG, "Title to send: " + filename);
		Log.i(TAG, "Content to send: " + content);

		Intent i = new Intent();
		i.setAction(Intent.ACTION_SEND);
		i.setType(mMimeTypes.getMimeType(file.getName()));
		i.putExtra(Intent.EXTRA_SUBJECT, filename);
		//i.putExtra(Intent.EXTRA_STREAM, FileUtils.getUri(file));
		i.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://" + FileManagerProvider.AUTHORITY + "/mimetype/" + file.getAbsolutePath()));

		i = Intent.createChooser(i, getString(R.string.menu_send));
		
		try {
			startActivity(i);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(this, R.string.send_not_available,
					Toast.LENGTH_SHORT).show();
			Log.e(TAG, "Email client not installed");
		}
	}

