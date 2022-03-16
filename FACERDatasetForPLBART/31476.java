    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        //mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mWeatherUpdateReceiver = new WeatherUpdateReceiver();
        startServices();
    }

