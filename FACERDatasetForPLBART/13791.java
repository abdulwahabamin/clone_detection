    @Override
    public void onBackPressed() {
        super.onBackPressed();
        splashTimer.cancel();
        splashTimer.onFinish();
    }

