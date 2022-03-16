    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null)
            return;

        askForInfos(intent.getStringExtra("apiUrl"));
    }

