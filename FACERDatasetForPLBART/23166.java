    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler mHandler = new Handler();


        mHandler.postDelayed(mLaunchTask, MYDELAYTIME);
    }

