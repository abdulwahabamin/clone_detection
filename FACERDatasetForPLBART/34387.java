        private String getVersionName() {
            String versionName;
            try {
                versionName = mPackageManager.getPackageInfo(getActivity().getPackageName(),
                                                             0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Get version name error", e);
                versionName = "666";
            }
            return versionName;
        }

