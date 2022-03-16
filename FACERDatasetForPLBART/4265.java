	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		activity=(AppCompatActivity) getActivity();
		view=inflater.inflate(R.layout.search_shortcut,container, false);
        animation= AnimationUtils.loadAnimation(activity, R.anim.slide_in_from_bottom);
		return view;
	}

