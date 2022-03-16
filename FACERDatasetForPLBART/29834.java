    public void showFab() {
        fab.show();
        findViewById(R.id.fabProgressCircle).setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        } , 500);
    }

