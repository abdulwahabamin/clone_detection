	public FileItem(String filename, Integer icon, String path) {
		super(path+ File.separator+filename);
		this.file = filename;
		this.icon = icon;
		//this.absolutePath=absolutePath;
	}

