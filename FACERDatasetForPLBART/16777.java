    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FireLog.d(TAG, "(++) onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_playback_controls, container, false);

        bgView = (ImageView) rootView.findViewById(R.id.bgView);
        playPause = (ImageButton) rootView.findViewById(R.id.playPause);
        playPause.setEnabled(true);
        playPause.setOnClickListener(onClickListener);

        title = (TextView) rootView.findViewById(R.id.title);
        subtitle = (TextView) rootView.findViewById(R.id.artist);
        albumArt = (ImageView) rootView.findViewById(R.id.albumArt);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionHelper.startNowPlayingActivity(getActivity());
            }
        });
        return rootView;
    }

