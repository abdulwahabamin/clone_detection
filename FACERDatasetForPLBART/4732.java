	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        //Log.e("RESUME", "FileExploreFrAGMENT CREATE: "+this.getClass().getCanonicalName());
        //Validator.logCaller();
		this.container=container;
		this.inflater=inflater;
		this.activity=(AppCompatActivity) getActivity();

		fm= new FileManagerFolders();
			//fm.init(activity);


		thisFragment=this;
		view=inflater.inflate(R.layout.pop_folder_choose,container, false);

		//fileExplorerHandler.postDelayed(fileExplorerRunner, 10);
		return view;


	}

