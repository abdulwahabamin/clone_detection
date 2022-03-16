    @Override
    protected void onHandleIntent(Intent intent) {
        Log.v(TAG, "onHandleIntent(" + intent + ")");
        if (intent == null) {
            Log.w(TAG, "Intent passed was null");
            return;
        }
        String action = intent.getAction();
        Log.d(TAG, "Action: " + action);
        if (TextUtils.isEmpty(action)) {
            Log.w(TAG, "Failed to parse action");
            return;
        }
        String fileRoot = intent.getStringExtra(EXTRA_FILE_ROOT);
        if (TextUtils.isEmpty(fileRoot)) {
            Log.w(TAG, "Empty file root, bailing out");
            return;
        }
        if (ACTION_START_INDEX.equalsIgnoreCase(action)) {
            performIndexAction(fileRoot);
        }
    }

