    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_songs, container, false);

        RecyclerView songRecyclerView = (RecyclerView) rootView.findViewById(R.id.songList);

        songRecyclerView.setHasFixedSize(true);

        songRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        songRecyclerView.setAdapter(songAdapter);

        songRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                songAdapter.cancelImageLoad(holder);
            }
        });

        songAdapter.notifyDataSetChanged();

        return rootView;
    }

