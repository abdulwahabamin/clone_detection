    public static IconCacheRetainFragment findOrCreateRetainFragment(
            FragmentManager fragmentManager) {
        IconCacheRetainFragment fragment = (IconCacheRetainFragment) fragmentManager
                .findFragmentByTag(TAG);
        if (fragment == null) {
            fragment = new IconCacheRetainFragment();
            fragmentManager.beginTransaction().add(fragment, TAG).commit();
        }
        return fragment;
    }

