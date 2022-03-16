    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        adapter = new ProvinceListAdapter(provinces, MyApplication.getAppContext());
        View view = inflater.inflate(R.layout.fragment_province, container, false);
        initView(view);
        return view;
    }

