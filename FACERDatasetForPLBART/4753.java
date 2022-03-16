	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		this.container=container;
		this.inflater=inflater;
		this.activity=(AppCompatActivity)getActivity();

		
		view=inflater.inflate(R.layout.images_slider,container, false);

		toolbar = (Toolbar) activity.findViewById(R.id.toolbar);

		//fileExplorerHandler.postDelayed(fileExplorerRunner, 10);
		return view;
		

	}

