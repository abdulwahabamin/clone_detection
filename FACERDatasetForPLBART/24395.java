    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        mainView = view.findViewById(R.id.player_footer);

        currentTime = (TextView) view.findViewById(R.id.currenttime);
        totalTime = (TextView) view.findViewById(R.id.totaltime);

        progressBar = (ProgressBar) view.findViewById(android.R.id.progress);
        if (progressBar instanceof SeekBar) {
            SeekBar seeker = (SeekBar) progressBar;
            seeker.setOnSeekBarChangeListener(mSeekListener);
        }
        progressBar.setMax(1000);

        RepeatingImageButton prevButton = (RepeatingImageButton) view.findViewById(R.id.prev);
        prevButton.setOnClickListener(v -> {
            if (service == null) return;
            service.previousOrRestartCurrent();
        });
        prevButton.setRepeatListener((v, howlong, repcnt) -> scanBackward(repcnt, howlong), 260);
        pauseButton = (ImageButton) view.findViewById(R.id.pause);
        pauseButton.requestFocus();
        pauseButton.setOnClickListener(v -> doPauseResume());
        RepeatingImageButton nextButton = (RepeatingImageButton) view.findViewById(R.id.next);
        nextButton.setOnClickListener(v -> {
            if (service == null) return;
            service.next();
        });
        nextButton.setRepeatListener((v, howlong, repcnt) -> scanForward(repcnt, howlong), 260);

        return view;
    }

