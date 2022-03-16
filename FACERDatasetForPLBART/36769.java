    public static CardFragment newInstance(County county) {
        Bundle args = new Bundle();
        args.putSerializable(Consts.EXTRA_COUNTY, county);
        CardFragment fragment = new CardFragment();
        fragment.setArguments(args);
        return fragment;
    }

