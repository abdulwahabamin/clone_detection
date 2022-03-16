	@Override
	public ParcelFileDescriptor openFile(Uri uri, String mode)
			throws FileNotFoundException {
		if (uri.toString().startsWith(FILE_PROVIDER_PREFIX)) {
			int m = ParcelFileDescriptor.MODE_READ_ONLY;
			if (mode.equalsIgnoreCase("rw"))
				m = ParcelFileDescriptor.MODE_READ_WRITE;
			File f = new File(uri.getPath());
			ParcelFileDescriptor pfd = ParcelFileDescriptor.open(f, m);
			return pfd;
		} else {
			throw new FileNotFoundException	("Unsupported uri: " + uri.toString());
		}
	}

