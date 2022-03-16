    private Fragment getHomeFragment() {
        List<String> storageList = ((FMApplication) getApplication()).getStorageDirectories();
        switch (navItemIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                // storage path
                return StorageFragment.getInstance(storageList.get(navItemIndex));
            case 5:
                // root path
                return StorageFragment.getInstance("/");

            case 6:
                // apps
                return AppFragment.getInstance();

            default:
                return DefaultFragment.getInstance();
        }
    }

