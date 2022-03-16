    private void initView() {
        musicService = RairApp.getApp() .getService();
        fragments = new Fragment[5];
        handler = new Handler();
        showFragment(0);
        checkPermission();
    }

