    public void initEvent() {
        startService();
        MainThreadAction.getInstance().post(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        },3500);
    }

