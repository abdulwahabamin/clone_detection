    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tv_play_queue_fragment, container, false);

        VerticalGridView list = (VerticalGridView) view.findViewById(android.R.id.list);
        adapter = new CursorObjectAdapter(new SongRowPresenter());
        list.setAdapter(new ClickableItemBridgeAdapter(adapter, this));

        return view;
    }

