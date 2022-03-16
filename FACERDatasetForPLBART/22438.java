    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lyrics, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        setupToolbar();

        loadLyrics();

        return rootView;
    }

