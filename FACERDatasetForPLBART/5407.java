	public Intent getAbsoluteOpenableIntent(String file) {
		if (isExists(file) && new File(file)
				.isFile()) {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			Uri uri = Uri.fromFile(new File(file));

			String type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap
					.getFileExtensionFromUrl(uri.toString()));
			intent.setDataAndType(uri, type);
			if (intent.resolveActivity(context.getPackageManager()) == null)
				return null;
			return intent;
		} else {

			return null;
		}
	}

