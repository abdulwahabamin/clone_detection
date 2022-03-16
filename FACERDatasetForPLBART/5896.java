	public void openFile(File f)
	{
		try
		{
			String mime_type = mime_type_map.getMimeTypeFromExtension(
				MimeTypeMap.getFileExtensionFromUrl(
					f.toURL().toString()
				)
			);
			Intent intent = new Intent(Intent.ACTION_VIEW);
			Uri uri = Uri.fromFile(f);
			if(mime_type != null)
				intent.setDataAndType(uri, mime_type);
			else
				intent.setData(uri);

			startActivity(intent);
		}
		catch(Exception e)
		{
			showToast(R.string.no_app_to_open_file);
		}
	}

