    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        viewPager = findViewById(R.id.viewPager);

        // Set an Adapter on the ViewPager
        viewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));

        // Set a PageTransformer
        viewPager.setPageTransformer(false, new IntroPageTransformer());
        checkPermissions();
    }

