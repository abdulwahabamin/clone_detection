    @Override
    public void initViews() {
        setSupportActionBar(mTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.about);

        mVersion.setText(mVersion.getText() + Version.getVersionName(this));

        loadUpgradeInfo();
    }

