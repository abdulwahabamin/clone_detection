	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		//frag=this;
		this.activity=(FragmentActivity) getActivity();
		//this.savedInstanceState=savedInstanceState;
		view=inflater.inflate(R.layout.settings_tabbed_frame,container, false);
		//startHandler.postDelayed(initialise, 50);
		return view;
	}

