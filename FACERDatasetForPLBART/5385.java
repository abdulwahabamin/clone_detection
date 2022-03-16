	static boolean isValidFile(String ext){
		for(String extension:extensions){
			if(extension.equals(ext))
				return true;
		}
		return false;
	}

