    @Override
    protected void initView() {
        setContentView(R.layout.activity_splash);
        //mUnbinder = ButterKnife.bind(this);

        ivSplashIcon = (ImageView)findViewById(R.id.iv_splash_icon);

        mPresenter = new SplashPresenter();
    }

