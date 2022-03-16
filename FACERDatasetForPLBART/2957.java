    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.Detial_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        TextView total = (TextView) findViewById(R.id.detial_total);
        TextView free = (TextView) findViewById(R.id.detial_free);
        total.setText(getIntent().getStringExtra("total"));
        free.setText(getIntent().getStringExtra("free"));

        String model = DeviceUtils.getModel();
        String manufacturer = DeviceUtils.getManufacturer();
        boolean root = DeviceUtils.isDeviceRoot();
        int version = DeviceUtils.getSDKVersion();
        String IMEI = PhoneUtils.getIMEI(this);

        TextView DetailModelModel = (TextView) findViewById(R.id.detial_model);
        DetailModelModel.setText(model);
        TextView DetailFactory = (TextView) findViewById(R.id.detial_factory);
        DetailFactory.setText(manufacturer);
        TextView DetailIMEI = (TextView) findViewById(R.id.detial_imei);
        DetailIMEI.setText(IMEI);

        TextView DetailRoot = (TextView) findViewById(R.id.detial_root);
        if (root) {
            DetailRoot.setText("你的设备已Root");
        } else
            DetailRoot.setText("您的设备未Root");
        TextView DetailVersion = (TextView) findViewById(R.id.detial_version);
        if (version == 23) {
            DetailVersion.setText("6.0.0");
        } else if (version == 22) {
            DetailVersion.setText("5.1.0");
        } else if (version == 21) {
            DetailVersion.setText("5.0.0");
        } else if (version == 20) {
            DetailVersion.setText("4.4.0 W");
        } else if (version == 19) {
            DetailVersion.setText("4.4.0");
        } else if (version == 18) {
            DetailVersion.setText("4.3.0");
        } else if (version == 17) {
            DetailVersion.setText("4.2.0");
        } else if (version == 16) {
            DetailVersion.setText("4.1.0");
        } else if (version == 15) {
            DetailVersion.setText("4.0.0");
        } else if (version <= 14) {
            DetailVersion.setText("�?�喜，你是地�?�上Android版本最低的3%的人之一。");
        }
    }

