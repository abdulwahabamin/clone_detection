	@Override
	public Cursor query(Uri uri, String[] projection, String s, 
			String[] as1, String s1) {
		if (uri.toString().startsWith(FILE_PROVIDER_PREFIX)) {
			if (projection == null || projection.length == 0) {
				// Standard projection including all supported rows
				projection = new String [] {
								MediaStore.MediaColumns.DATA,
								MediaStore.MediaColumns.MIME_TYPE,
								MediaStore.MediaColumns.DISPLAY_NAME,
								MediaStore.MediaColumns.SIZE};
			} 
			
			MatrixCursor c = new MatrixCursor(projection);
			MatrixCursor.RowBuilder row = c.newRow();
			
			// data = absolute path to file
			String data = uri.getPath();
			
			int fromIndex = data.lastIndexOf(File.separatorChar) + 1;
			if (fromIndex >= data.length()) {
				// Last character was '/' or data is empty, so no file name 
				// was specified and we don't want to raise an 
				// IndexOutOfBoundsException
				throw new RuntimeException("No file name specified: ".concat(data));
			}
			
			// According to Android docs, DISPLAY_NAME should be
			// the last segment of Uri
			String displayName = 
				(fromIndex > 0) ? data.substring(fromIndex) : data;
			
			String mimeType = mMimeTypes.getMimeType(data);
				
			long size = -1;
			File file = new File(data);			
			if (file.exists() && file.isFile()) {
				size = file.length();
			}
			
			for (String col : projection) {
				if (col.equals(MediaStore.MediaColumns.DATA)) {
					row.add(data);
				} else if (col.equals(MediaStore.MediaColumns.MIME_TYPE)) {
					row.add(mimeType);
				} else if (col.equals(MediaStore.MediaColumns.DISPLAY_NAME)) {
					row.add(displayName);
				} else if (col.equals(MediaStore.MediaColumns.SIZE)) {
					if (size >= 0)
						row.add(size);
					else {
						// According to Android docs for unknown size.
						// Standard getLong() won't throw exception and
						// value will be 0.
						row.add(null);
					}
				} else {
					// Unsupported or unknown columns are filled up with null
					row.add(null);
				}
			}
			
			return c;
		} else {
			throw new RuntimeException("Unsupported uri");
		}
	}

