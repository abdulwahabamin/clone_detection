	private FileEx(String dir) {
		try {
			file = new File(dir);
			currentDir = dir;
			defaultDir = dir;
			previousDir = null;

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

