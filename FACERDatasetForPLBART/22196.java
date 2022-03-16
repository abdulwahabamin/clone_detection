    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_timber5, container, false);

        setMusicStateListener();
        setSongDetails(rootView);

        mBlurredArt = (ImageView) rootView.findViewById(R.id.album_art_blurred);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.queue_recyclerview_horizontal);
        initGestures(mBlurredArt);
        setupSlidingQueue();

        return rootView;
    }

