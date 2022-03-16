    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        nowPlaying = inflater.inflate(R.layout.nowplaying, container, false);

        titleView = (TextView) nowPlaying.findViewById(R.id.title);
        artistView = (TextView) nowPlaying.findViewById(R.id.artist);
        nowPlaying.setOnClickListener(v -> startActivity(new Intent(getActivity(), MediaPlaybackActivity.class)));

        View prevButton = nowPlaying.findViewById(R.id.prev);
        if (prevButton != null) {
            prevButton.setOnClickListener(v -> {
                if (service != null) service.previousOrRestartCurrent();
            });
        }
        nowPlaying.findViewById(R.id.next).setOnClickListener(v -> {
            if (service != null) service.next();
        });
        playPauseButton = (ImageButton) nowPlaying.findViewById(R.id.pause);
        playPauseButton.setOnClickListener(v -> {
            if (service != null) {
                if (service.isPlaying()) {
                    service.pause();
                } else {
                    service.play();
                }
            }
        });

        return nowPlaying;
    }

