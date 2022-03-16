	public FileItem(File file) {
		super(file.getAbsolutePath());
		this.file = this.getName();
		this.icon = Files.getFileRIcon(this.file);
		//this.absolutePath=absolutePath;
	}

