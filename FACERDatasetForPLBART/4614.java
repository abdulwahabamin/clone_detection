	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		this.container=container;
		this.inflater=inflater;
		this.activity=(AppCompatActivity) getActivity();
		
		fm=(FileManagerDisk) State.getCachedFileManager(FileManagerDisk.class);
		
		view=inflater.inflate(R.layout.file_explore_delete,container, false);
		//fileExplorerHandler.postDelayed(fileExplorerRunner, 10);
		return view;
		

	}

