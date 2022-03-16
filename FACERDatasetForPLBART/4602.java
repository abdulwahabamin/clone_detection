	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		this.container=container;
		this.inflater=inflater;
		this.activity=(AppCompatActivity) getActivity();
		
		
		
		view=inflater.inflate(R.layout.file_explore_archive,container, false);
		//fileExplorerHandler.postDelayed(fileExplorerRunner, 10);
		return view;
		

	}

