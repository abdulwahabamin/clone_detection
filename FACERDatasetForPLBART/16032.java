    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_library, container, false);

        librarySpinner = (Spinner) rootView.findViewById(R.id.library_spinner);

         initSpinner();

        if(!fragmentInitialized) {
            songsFragment = SongsFragment.newInstance(Library.getSongs(null),this);

            albumsFragment = AlbumsFragment.newInstance(Library.getAlbums(null), this);
        }

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.library_toolbar);
        AppCompatActivity mainActivity = (AppCompatActivity)getActivity();

        mainActivity.setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) mainActivity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(mainActivity,
                drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.library_view_pager);
        pagerAdapter = new LibraryPagerAdapter(getChildFragmentManager(), songsFragment, albumsFragment);
        viewPager.setAdapter(pagerAdapter);

        ((TabLayout)rootView.findViewById(R.id.library_tab_layout)).setupWithViewPager(viewPager);

        fragmentInitialized = true;
        return rootView;
    }

