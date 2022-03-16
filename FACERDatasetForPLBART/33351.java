    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container);

        createCustomDialogTitle(view);

        recyclerView = (RecyclerView) view.findViewById(R.id.general_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        int listDividerHeight = (int) getResources().getDimension(R.dimen.list_divider_height);
        recyclerView.addItemDecoration(new ItemDecorationListDivider(listDividerHeight));

        return view;
    }

