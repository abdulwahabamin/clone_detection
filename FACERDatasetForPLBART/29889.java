    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mValueFormatter = new CustomFormatter();
        pf = new Prefs(getContext());
        setHasOptionsMenu(true);
    }

