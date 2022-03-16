    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewFragment = (MainViewFragment) getFragmentManager().findFragmentById(R.id.file_list);
    }

