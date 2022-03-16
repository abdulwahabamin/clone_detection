	public int loadDirectory() {
		//if(!currentPath.equals(inMemoryPath)) {
			inMemoryPath = currentPath;

			File dir = new File(currentPath);
			rawList = dir.list();
		//}
		return rawList.length;
	}

