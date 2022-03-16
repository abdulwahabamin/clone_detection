    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabs, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.hour_list);
        setupRecyclerView(recyclerView);
        ILocalDataSource localDataSource = LocalDataSource.getInstance(getContext());
        addWeathersToList(localDataSource.getForecast(getArguments().getInt(CITY_ID),
                new Date(getArguments().getLong(DATE))));

        return view;
    }

