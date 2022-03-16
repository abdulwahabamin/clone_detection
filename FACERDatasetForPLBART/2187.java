    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mDistribution = new DistributionLibrary(this, MENU_DISTRIBUTION_START, DIALOG_DISTRIBUTION_START);
    }

