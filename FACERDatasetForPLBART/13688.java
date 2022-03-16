    public static StorageFragment getInstance(String path) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY, path);

        StorageFragment fragment = new StorageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

