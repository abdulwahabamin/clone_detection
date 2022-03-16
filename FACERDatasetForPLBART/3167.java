	ThumbnailLoader(File file, List<IconifiedText> list, Handler handler, Context context) {
		super("Thumbnail Loader");
		
		listFile = list;
		this.file = file;
		this.handler = handler;
		this.context = context;
	}

