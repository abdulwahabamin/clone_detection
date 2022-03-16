	private String getPath(Uri uri){
		Uri sd = Uri.fromFile(Environment.getExternalStorageDirectory());
		if(uri.getHost().equals("gmail-ls")){
			Cursor cur = managedQuery(uri, new String[]{"_display_name"}, null, null, null);
			int nameColumn = cur.getColumnIndex("_display_name"); 
			if(cur.moveToFirst()){
				return sd.buildUpon().appendPath(cur.getString(nameColumn)).toString();
			}
		}
		return sd.getPath();
	}

