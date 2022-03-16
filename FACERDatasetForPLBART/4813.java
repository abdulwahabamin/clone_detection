	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		this.container=container;
		this.inflater=inflater;
		this.activity=(AppCompatActivity)getActivity();



		fm= (FileManagerZip) State.getCachedFileManager(FileManagerZip.class);
		if(fm==null) {
			//Log.e("FS","Zip from state: "+State.getStateObjectString(State.SECTION_FILE_EXPLORE_ARCHIVE, StateObject.STRING_FILE_PATH));
			fm=new FileManagerZip(State.getStateObjectString(State.SECTION_FILE_EXPLORE_ARCHIVE, StateObject.STRING_FILE_PATH));
			fm.refresh(activity);
		}


        thisFragment=this;

		view=inflater.inflate(R.layout.file_explore_archive_view_extract,container, false);

		return view;


	}

