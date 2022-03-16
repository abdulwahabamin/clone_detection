	DirectoryScanner(File directory, Context context, Handler handler, MimeTypes mimeTypes, String sdCardPath) {
		super("Directory Scanner");
		currentDirectory = directory;
		this.context = context;
		this.handler = handler;
		this.mMimeTypes = mimeTypes;
		this.mSdCardPath = sdCardPath;
	}

