	public static boolean ensurePath(String path) {
		boolean ok=true;
		File filedir = new File(path);
		if(!filedir.exists())
			ok=filedir.mkdirs();

		return ok;
	}

