    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_timber4, container, false);

        setMusicStateListener();
        setSongDetails(rootView);

        mBlurredArt = (ImageView) rootView.findViewById(R.id.album_art_blurred);
        horizontalRecyclerview = (RecyclerView) rootView.findViewById(R.id.queue_recyclerview_horizontal);

        setupHorizontalQueue();
        initGestures(mBlurredArt);

        return rootView;
    }

