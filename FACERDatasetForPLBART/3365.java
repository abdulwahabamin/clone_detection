	public static void openAndroidFile(Activity activity, File file) {
		//File filesDir = getFilesDir();
		//Scanner input = new Scanner(new File(filesDir, filename));
        //BLog.e("OPENFILE",file.getAbsolutePath());
		if(file!=null) {
			String ext=Files.getExtension(Files.removeBriefFileExtension(file.getAbsolutePath()));
            if(ext!=null) {
                ext = ext.replace(".", "");
                String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext.toLowerCase());

                if (mime != null) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(file), mime);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //startActivityForResult(intent, 10);
                    //intent.setType("text/plain");
                    //intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file) );
					try {
						activity.startActivity(intent);
					} catch (Exception e) {
						Toast.makeText(activity, activity.getResources().getString(R.string.no_file_format), Toast.LENGTH_SHORT).show();
					}
                } else {
                    Toast.makeText(activity, activity.getResources().getString(R.string.no_file_format), Toast.LENGTH_SHORT).show();
                }
            }
		}
	}

