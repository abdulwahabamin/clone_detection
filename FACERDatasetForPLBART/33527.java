    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // important - we set a new intent as a default intent, so the search suggestions can
        // be handled properly
        setIntent(intent);
        handleIntent(getIntent());
    }

