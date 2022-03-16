	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.navigation_drawer_layout, null);
		mApp = (Common) getActivity().getApplicationContext();
		
		browsersListView = (ListView) rootView.findViewById(R.id.browsers_list_view);
		librariesListView = (ListView) rootView.findViewById(R.id.libraries_list_view);
		browsersHeaderText = (TextView) rootView.findViewById(R.id.browsers_header_text);
		librariesHeaderText = (TextView) rootView.findViewById(R.id.libraries_header_text);
		librariesColorTagImageView = (ImageView) rootView.findViewById(R.id.library_color_tag);
		librariesIcon = (ImageView) rootView.findViewById(R.id.libraries_icon);
		librariesIcon.setImageResource(UIElementsHelper.getIcon(getActivity(), "libraries"));
		
		Drawable backgroundDrawable;
		if (mApp.getCurrentTheme()== Common.DARK_THEME) {
			backgroundDrawable = new ColorDrawable(0x191919);
		} else {
			backgroundDrawable = getResources().getDrawable(R.drawable.holo_white_selector);
		}
		
		int currentAPI = android.os.Build.VERSION.SDK_INT;
		if (currentAPI < android.os.Build.VERSION_CODES.JELLY_BEAN) {
			rootView.setBackgroundDrawable(backgroundDrawable);
		} else {
			rootView.setBackground(backgroundDrawable);
		}
		
		//Set the header text fonts/colors.
		browsersHeaderText.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
		librariesHeaderText.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
		browsersHeaderText.setPaintFlags(browsersHeaderText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.FAKE_BOLD_TEXT_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		librariesHeaderText.setPaintFlags(librariesHeaderText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.FAKE_BOLD_TEXT_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		//Apply the Browser ListView's adapter.
		List<String> titles = Arrays.asList(getActivity().getResources().getStringArray(R.array.sliding_menu_array));
		NavigationDrawerAdapter slidingMenuAdapter = new NavigationDrawerAdapter(getActivity(), new ArrayList<String>(titles));
		browsersListView.setAdapter(slidingMenuAdapter);
		browsersListView.setOnItemClickListener(browsersClickListener);
		setListViewHeightBasedOnChildren(browsersListView);
		
		/*//Apply the Libraries ListView's adapter.
		userLibrariesDBHelper = new DBAccessHelper(getActivity().getApplicationContext());
		cursor = userLibrariesDBHelper.getAllUniqueLibraries();
		NavigationDrawerLibrariesAdapter slidingMenuLibrariesAdapter = new NavigationDrawerLibrariesAdapter(getActivity(), cursor);
		librariesListView.setAdapter(slidingMenuLibrariesAdapter);
		setListViewHeightBasedOnChildren(librariesListView);*/
		librariesListView.setVisibility(View.GONE);
		librariesHeaderText.setVisibility(View.GONE);
		librariesIcon.setVisibility(View.GONE);

		return rootView;
	}

