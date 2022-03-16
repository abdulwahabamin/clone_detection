    @Override
    public void onReceive(Context context, Intent intent) {
        final ContentResolver resolver = context.getContentResolver();

        final String action = intent.getAction();
        if (Intent.ACTION_PACKAGE_FULLY_REMOVED.equals(action)) {
            resolver.call(RecentsProvider.buildRecent(), RecentsProvider.METHOD_PURGE, null, null);

        } else if (Intent.ACTION_PACKAGE_DATA_CLEARED.equals(action)) {
            final Uri data = intent.getData();
            if (data != null) {
                final String packageName = data.getSchemeSpecificPart();
                resolver.call(RecentsProvider.buildRecent(), RecentsProvider.METHOD_PURGE_PACKAGE,
                        packageName, null);
            }
        }
    }

