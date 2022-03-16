    public static final ImageCache findOrCreateCache(final Activity activity) {    	
    	FragmentManager nFragmentManger = activity.getFragmentManager();
        RetainFragment retainFragment = (RetainFragment)nFragmentManger.findFragmentByTag(TAG);
        if (retainFragment == null) {
            retainFragment = new RetainFragment();
            nFragmentManger.beginTransaction().add(retainFragment, TAG).commit();
        }
        ImageCache cache = (ImageCache)retainFragment.getObject();
        if (cache == null) {
            cache = getInstance(activity);
            retainFragment.setObject(cache);
        }
        return cache;
    }

