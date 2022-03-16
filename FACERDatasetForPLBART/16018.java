    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_albums, container, false);

        RecyclerView albumRecyclerView = (RecyclerView) rootView.findViewById(R.id.albumList);

        albumRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        albumRecyclerView.setLayoutManager(layoutManager);

        albumRecyclerView.setAdapter(albumAdapter);

        albumRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                albumAdapter.cancelImageLoad(holder);
            }
        });

        albumAdapter.notifyDataSetChanged();

        if(savedPosition != -1) {
            layoutManager.scrollToPosition(savedPosition);
        }

        return rootView;
    }

