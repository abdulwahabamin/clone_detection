	public FileItem(String filepath) {
		super(filepath);
		this.file = this.getName();
		this.icon = Files.getFileRIcon(this.file);
		//this.absolutePath=absolutePath;
	}

