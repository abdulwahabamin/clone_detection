	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        //Log.e("RESUME", "FileExploreFrAGMENT CREATE: "+this.getClass().getCanonicalName());
        //Validator.logCaller();
		this.container=container;
		this.inflater=inflater;
		this.activity=(AppCompatActivity) getActivity();


		thisFragment=this;
		view=inflater.inflate(R.layout.text_file_viewer,container, false);

		//fileExplorerHandler.postDelayed(fileExplorerRunner, 10);
		return view;


	}

