	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		mContext = getActivity();
		mApp = (Common) mContext.getApplicationContext();
		mHandler = new Handler();

		View rootView = inflater.inflate(R.layout.navigation_drawer_layout, null);
		rootView.setBackgroundColor(UIElementsHelper.getBackgroundColor(mContext));

		browsersListView = (ListView) rootView.findViewById(R.id.browsers_list_view);
        mLibraryPickerLayout = (RelativeLayout) rootView.findViewById(R.id.library_picker_layout);
        mLibraryPickerSpinner = (Spinner) rootView.findViewById(R.id.library_picker_spinner);
        mLibraryPickerHeaderText = (TextView) rootView.findViewById(R.id.library_picker_header_text);
        mLibraryPickerHeaderText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
		
		//Apply the Browser ListView's adapter.
		List<String> titles = Arrays.asList(getActivity().getResources().getStringArray(R.array.sliding_menu_array));
		mBrowsersAdapter = new NavigationDrawerAdapter(getActivity(), new ArrayList<String>(titles));
		browsersListView.setAdapter(mBrowsersAdapter);
		browsersListView.setOnItemClickListener(browsersClickListener);
		setListViewHeightBasedOnChildren(browsersListView);

		//Apply the Libraries ListView's adapter.
        cursor = mApp.getDBAccessHelper().getAllUniqueLibraries();
        mLibrariesAdapter = new NavigationDrawerLibrariesAdapter(getActivity(), cursor);
        mLibraryPickerSpinner.setAdapter(mLibrariesAdapter);
        mLibraryPickerSpinner.setSelection(mApp.getCurrentLibraryIndex());
        mLibraryPickerSpinner.setOnItemSelectedListener(librariesItemSelectedListener);

        browsersListView.setDividerHeight(0);

        //KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int navBarHeight = Common.getNavigationBarHeight(mContext);
            if (browsersListView!=null) {
                browsersListView.setPadding(0, 0, 0, navBarHeight);
                browsersListView.setClipToPadding(false);
            }

        }

		return rootView;
	}

