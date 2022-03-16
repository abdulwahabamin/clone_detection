    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_recycler_view, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.general_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        int listDividerHeight = (int) getResources().getDimension(R.dimen.list_divider_height);
        recyclerView.addItemDecoration(new ItemDecorationListDivider(listDividerHeight));

        ThreeHourlyForecastAdapter adapter = new ThreeHourlyForecastAdapter(getArguments()
                .getStringArrayList(JSON_STRING_LIST));
        recyclerView.setAdapter(adapter);

        return view;
    }

