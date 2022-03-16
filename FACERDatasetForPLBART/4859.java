	public static boolean isTextFile(String filename) {
		filename=filename.toLowerCase();
		if(filename.endsWith(".txt")
				|| filename.endsWith(".css")
				|| filename.endsWith(".java")
				|| filename.endsWith(".pl")
				|| filename.endsWith(".js")
				|| filename.endsWith(".jsp")
                || filename.endsWith(".xml")
                || filename.endsWith(".sql")
				|| filename.endsWith(".out")
				) {
			return true;
		}
		return false;

	}

