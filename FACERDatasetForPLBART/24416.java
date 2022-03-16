    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_header, container, false);

        mainView = view.findViewById(R.id.player_header);

        trackNameView = (TextView) view.findViewById(R.id.trackname);
        artistNameView = (TextView) view.findViewById(R.id.artistname);
        genreNameView = (TextView) view.findViewById(R.id.genrename);
        trackNameContainer = view.findViewById(R.id.trackname_container);

        registerForContextMenu(trackNameContainer);
        artistNameView.setOnLongClickListener(this);
        genreNameView.setOnLongClickListener(this);

        view.findViewById(R.id.context_menu).setOnClickListener(v -> trackNameContainer.showContextMenu());

        return view;
    }

