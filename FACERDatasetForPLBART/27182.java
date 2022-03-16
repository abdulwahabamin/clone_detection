    public static CityDetailFragment getInstance(long itemId, String itemName) {
        Bundle args = new Bundle();
        args.putLong(ARG_ITEM_ID, itemId);
        args.putString(ARG_ITEM_NAME, itemName);
        CityDetailFragment cityDetailFragment = new CityDetailFragment();
        cityDetailFragment.setArguments(args);
        return cityDetailFragment;
    }

