    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getResources().getConfiguration().orientation == OrientationHelper.VERTICAL &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            supportFinishAfterTransition();
            initExitAnimation();
        }
    }

