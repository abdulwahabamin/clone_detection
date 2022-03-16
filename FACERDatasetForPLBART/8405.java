    /**
     * Initialize the activity. This method handles the passed intent, opens
     * the appropriate activity and ends.
     */
    private void init() {
        try {
            String type = getIntent().getStringExtra(EXTRA_TYPE);
            String path = getIntent().getStringExtra(EXTRA_FSO);

            // Check that i have a valid information
            if (type == null || type.length() == 0 || path == null || path.length() == 0) {
                // Something is wrong
                Log.w(TAG,
                        String.format(
                            "The shortcut intent couldn't be handled. Intent: %s", //$NON-NLS-1$
                            getIntent()));
                DialogHelper.showToast(this, R.string.shortcut_failed_msg, Toast.LENGTH_SHORT);
                finish();
                return;
            }
            if (type.compareTo(SHORTCUT_TYPE_NAVIGATE) != 0 &&
                type.compareTo(SHORTCUT_TYPE_OPEN) != 0) {
                // Something is wrong
                Log.w(TAG,
                        String.format(
                                "The shortcut intent type is unknown: %s", type)); //$NON-NLS-1$
                DialogHelper.showToast(this, R.string.shortcut_failed_msg, Toast.LENGTH_SHORT);
                finish();
                return;
            }

            // Initializes the console
            initializeConsole();

            // Retrieve the fso
            FileSystemObject fso =
                    CommandHelper.getFileInfo(getApplicationContext(), path, true, null);
            if (fso == null) {
                // Something is wrong
                Log.w(TAG,
                        String.format(
                                "The fso not exists: %s", path)); //$NON-NLS-1$
                DialogHelper.showToast(this, R.string.shortcut_failed_msg, Toast.LENGTH_SHORT);
                finish();
                return;
            }

            // Check what type of shortcut is registered and apply the best action
            if (type.compareTo(SHORTCUT_TYPE_NAVIGATE) == 0) {
                // We have to finish here; this activity is only a wrapper
                finish();

                // Forward to the NavigationActivity
                Intent intent = new Intent(this, NavigationActivity.class);
                intent.putExtra(NavigationActivity.EXTRA_NAVIGATE_TO, fso.getFullPath());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            } else {
                // Open the file. Delegate in action policy
                IntentsActionPolicy.openFileSystemObject(this, fso, false, this);
            }

        } catch (Exception e) {
            Log.e(TAG, "Failed to handle the shortcut intent.", e); //$NON-NLS-1$
            DialogHelper.showToast(this, R.string.shortcut_failed_msg, Toast.LENGTH_SHORT);
            finish();
        }
    }

