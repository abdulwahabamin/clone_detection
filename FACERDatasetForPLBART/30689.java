    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        // Set default selected item
        selectFragmentForMenuItemId(R.id.action_search);
    }

