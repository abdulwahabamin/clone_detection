	public int createDirectory(String dir) {
		if (isFile(dir))
			return DIRECTORY_ERROR;
		try {
			file = new File(dir);
			if (!file.exists()) {
				file.mkdir();
				return DIRECTORY_CREATED;
			} else
				return DIRECTORY_ALREADY_EXISTS;
		} catch (Exception e) {
			return DIRECTORY_ERROR;
		}
	}

