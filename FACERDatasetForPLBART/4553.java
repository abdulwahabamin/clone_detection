	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        //Log.e("RESUME", "FileExploreFrAGMENT CREATE: "+this.getClass().getCanonicalName());
        //Validator.logCaller();
		this.container=container;
		this.inflater=inflater;
		this.activity=(AppCompatActivity) getActivity();

		fm = (FileManagerDisk) State.getCachedFileManager(FileManagerDisk.class);
		if(fm==null) {
			fm=new FileManagerDisk();
			//fm.init(activity);
		}

		//State.clearStateAllObjects();

        thisFragment=this;
        fileSelectedActionSelecter= new FilesActionModeSelecter(activity,fm);

		view=inflater.inflate(R.layout.file_explore,container, false);
		
		//fileExplorerHandler.postDelayed(fileExplorerRunner, 10);
		return view;
		

	}

