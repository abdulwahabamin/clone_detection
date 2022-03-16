    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nowplaying, container, false);

        titleView = (TextView) view.findViewById(R.id.title);
        artistView = (TextView) view.findViewById(R.id.artist);
        view.findViewById(R.id.previous).setOnClickListener(v -> {
            if (service != null) service.previousOrRestartCurrent();
        });
        playPauseButton = (ImageButton) view.findViewById(R.id.play_pause);
        playPauseButton.setOnClickListener(v -> {
            if (service != null) {
                if (service.isPlaying()) {
                    service.pause();
                } else {
                    service.play();
                }
            }
        });
        view.findViewById(R.id.next).setOnClickListener(v -> {
            if (service != null) service.next();
        });
        return view;
    }

