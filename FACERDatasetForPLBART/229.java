    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_device);

        mDevice = getIntent().getParcelableExtra("device");

        if (mDevice == null) {
            Toast.makeText(this, "当�?选择设备有误,�?选�?", Toast.LENGTH_LONG).show();
            finish();
        }

        bindView();

        initView();

        registerReceiver();
    }

