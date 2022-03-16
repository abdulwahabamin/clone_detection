    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cityweatherfavorite, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

