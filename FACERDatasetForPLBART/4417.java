	public static void shareFile(Context context, String absolutFilePath) {
		if(absolutFilePath!=null) {
			File f = new File(absolutFilePath);
			if(!f.isDirectory()) {
				String ext=Files.getExtension(Files.removeBriefFileExtension(f.getAbsolutePath()));
				ext = ext.replace(".", "");
				String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext.toLowerCase());

				if (mime != null) {

					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.setDataAndType(Uri.fromFile(f), mime);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					//startActivityForResult(intent, 10);
					//intent.setType("text/plain");
					//intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file) );
					context.startActivity(intent);
				} else {
					Toast.makeText(context, context.getResources().getString(R.string.no_file_format), Toast.LENGTH_SHORT).show();
				}
			}
		}


	}

