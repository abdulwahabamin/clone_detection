	public static int getFolderPosition(String absPath) {
		if(S.activefolderstore.get(absPath)==null)
			return 0;
		else
			return S.activefolderstore.get(absPath);
	}

