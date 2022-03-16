	public static boolean isVideo(String filename) {
		filename=filename.toLowerCase();
		if(filename.endsWith(".mp4")
				|| filename.endsWith(".mov")
				) {
			return true;
		}
		return false;

	}

