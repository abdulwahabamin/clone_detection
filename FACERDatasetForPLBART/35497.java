    @Override
    public void initData() {
        ButterKnife.bind(this);
        tag = getIntent().getBundleExtra("result").getString("keyWord");
        link = getIntent().getBundleExtra("result").getString("url");
    }

