    private void findView() throws NameNotFoundException {
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setText("关于");
        version = (TextView) findViewById(R.id.version);
        PackageManager manager = getPackageManager();
        PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
        String versionCode = info.versionName;
        version.setText("Version：" + versionCode);
        share_app = (Button) findViewById(R.id.share_app);
        share_app.setOnClickListener(this);
        check_welcome = (Button) findViewById(R.id.check_welcome);
        check_welcome.setOnClickListener(this);
        feed_back = (Button) findViewById(R.id.feed_back);
        feed_back.setOnClickListener(this);
        project_address = (Button) findViewById(R.id.project_address);
        project_address.setOnClickListener(this);
        my_blog = (Button) findViewById(R.id.my_blog);
        my_blog.setOnClickListener(this);
        qq_qun = (Button) findViewById(R.id.qq_qun);
        qq_qun.setOnClickListener(this);
    }

