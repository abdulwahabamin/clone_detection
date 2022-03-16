    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FireLog.d(TAG, "(++) onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        adapter = new MainAdapter(getActivity(), medias);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new FireRecyclerItemClickListener(getActivity(),
                recyclerView, new FireRecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FireUtils.preventDoubleClick();
                onCategorySelectedListener.onCategorySelected(adapter.getItem(position));
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        // setting title of activity when user returns to CategoryFragment form MediaListFragment
        getActivity().setTitle(title);
        return view;
    }

