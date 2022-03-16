    @Override
    protected void onPause() {
        super.onPause();

        saveActiveTab(getActionBar());
    }

