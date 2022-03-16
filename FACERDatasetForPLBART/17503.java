    @Override
    protected void onDestroy() {
        super.onDestroy();
        colorAnimation.cancel();
        colorAnimation.end();
    }

