    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_timber2, container, false);

        setMusicStateListener();
        setSongDetails(rootView);
        mBlurredArt = (ImageView) rootView.findViewById(R.id.album_art_blurred);

        initGestures(mBlurredArt);

        return rootView;
    }

