	public static boolean isImage(String filename) {
		filename=filename.toLowerCase();
		if(filename.endsWith(".jpg")
				|| filename.endsWith(".gif")
				|| filename.endsWith(".png")
				|| filename.endsWith(".jpeg")
				|| filename.endsWith(".tif")
				|| filename.endsWith(".tiff")
				|| filename.endsWith(".bmp")
				) {
			return true;
		}
		return false;			
		
	}

