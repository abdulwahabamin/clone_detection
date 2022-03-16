    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_connectivity, container, false);

        if(homeFragment == null) {
            homeFragment = ConnectivityHomeFragment.newInstance(this);
        }
        if(connectivityFragmentSwitcher == null) {
            connectivityFragmentSwitcher = new FragmentSwitcher(getFragmentManager(),
                    R.id.fragment_connectivity_main_container);

            if(ShareGroup.shareGroupWeakReference != null
                    && ShareGroup.shareGroupWeakReference.get() != null) {
                ShareGroup group = ShareGroup.shareGroupWeakReference.get();
                if(group.getMode() == ShareGroup.Mode.CREATE_GROUP) {
                    createFragment = CreateGroupFragment.newInstance(group, this);
                    connectivityFragmentSwitcher.switchTo(createFragment, CREATE_FRAGMENT_TAG);
                } else {
                    joinFragment = JoinGroupFragment.newInstance(group, this);
                    connectivityFragmentSwitcher.switchTo(joinFragment, JOIN_FRAGMENT_TAG);
                }
            } else {
                connectivityFragmentSwitcher.switchTo(homeFragment, HOME_FRAGMENT_TAG);
            }
        }
        else {
            connectivityFragmentSwitcher.reattach();
        }

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.connectivity_toolbar);
        AppCompatActivity mainActivity = (AppCompatActivity)getActivity();

        mainActivity.setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) mainActivity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(mainActivity,
                drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        return rootView;
    }

