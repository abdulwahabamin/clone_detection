    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        ButterKnife.bind(this, view);

        mCounty = (County) getArguments().getSerializable(Consts.EXTRA_COUNTY);
        assert mCounty != null;
        mTvCountyName.setText(mCounty.getName());
        FetchWeatherInfoService.start(getContext(), mCounty);

        return view;
    }

