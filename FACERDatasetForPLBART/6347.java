        @Override
        public void onReceive(Context context, Intent intent) {
            final Uri data = intent.getData();
            if (data != null) {
                final String packageName = data.getSchemeSpecificPart();
                mRoots.updatePackageAsync(packageName);
            } else {
                mRoots.updateAsync();
            }
        }

