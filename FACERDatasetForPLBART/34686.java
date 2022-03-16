    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_manage, container, false);
        ButterKnife.bind(this, view);
        initView();
        initEvent();
        return view;
    }

