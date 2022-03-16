	private static String getFileExtension(String name) {
		int i = name.lastIndexOf('.');
		if (i > 0) {
			return name.substring(i + 1);
		}
		return "";
	}

