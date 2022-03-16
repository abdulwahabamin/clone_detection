    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PFASQLiteHelper pfasqLiteHelper = PFASQLiteHelper.getInstance(this);
        pfasqLiteHelper.getCityById(0);

        Intent mainIntent = new Intent(SplashActivity.this, TutorialActivity.class);
        SplashActivity.this.startActivity(mainIntent);
        SplashActivity.this.finish();
    }

