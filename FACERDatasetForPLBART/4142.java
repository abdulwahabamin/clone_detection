    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mDrawerView = inflater.inflate(R.layout.navigation_drawer, container, false);
        mDrawerListView=(GridView)mDrawerView.findViewById(R.id.nav_list);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        mDrawerListView.setAdapter(new ItemsAdapter(getActivity()));
        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
        //mDrawerView.setFitsSystemWindows(true);

        lastfiles = (GridView) mDrawerView.findViewById(R.id.nav_shortcuts);

        if(Device.isMediaMounted()) {
            IndexerDb.init(getActivity());

            new BuildLastFilesTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
            showDiskSizeDetails();
        }

        ImageView settings = (ImageView) mDrawerView.findViewById(R.id.btn_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout != null) {
                    mDrawerLayout.closeDrawer(mFragmentContainerView);
                }
                Bgo.openFragmentBackStack(activity, new SettingsHomeTabbedFragment());
            }
        });
        ImageView hdd = (ImageView) mDrawerView.findViewById(R.id.btn_nav_hdd);
        hdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout != null) {
                    mDrawerLayout.closeDrawer(mFragmentContainerView);
                }
                State.addToState(State.SECTION_FILE_EXPLORE,new StateObject(StateObject.STRING_FILE_PATH,"/"));
                Bgo.refreshCurrentFragment(activity);
            }
        });
        ImageView sdcard = (ImageView) mDrawerView.findViewById(R.id.btn_nav_sdcard);
        sdcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout != null) {
                    mDrawerLayout.closeDrawer(mFragmentContainerView);
                }
                State.addToState(State.SECTION_FILE_EXPLORE,new StateObject(StateObject.STRING_FILE_PATH,Files.getSDCardFilePath()));
                Bgo.refreshCurrentFragment(activity);
            }
        });
        //ImageView settings = (ImageView) mDrawerView.findViewById(R.id.btn_settings);



        return mDrawerView;
    }

