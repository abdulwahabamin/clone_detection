	public static List<FileItem> getResultsFileItems() {
		List<FileItem> items = new ArrayList<FileItem>();
		for(IndexerFile f: results) {
			items.add(f.getAsFileItem());
		}
		return items;
	}

