    /**
     * Creates the view for the user to see.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.music_cover_layout, container, false);

        currentSongName = (TextView) view.findViewById(R.id.currentSongName);
        currentTime = (TextView) view.findViewById(R.id.currentTime);
        totalTime = (TextView) view.findViewById(R.id.totalTime);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        repeatButton = (ImageView) view.findViewById(R.id.repeatButton);
        shuffleButton = (ImageView) view.findViewById(R.id.shuffleButton);
        previousButton = (ImageView) view.findViewById(R.id.previousButton);
        playButton = (ImageView) view.findViewById(R.id.playButton);
        nextButton = (ImageView) view.findViewById(R.id.nextButton);

        setupButtons();

        currentSongName.setText(fragmentCommunicator.getCurrentSongName());
        totalTime.setText(fragmentCommunicator.getSongLengthText());
        seekBar.setMax(fragmentCommunicator.getSongLength() / 1000);
        seekBar.setProgress(fragmentCommunicator.getCurrentSongPosition());

        repeatButton.setOnClickListener(new ImageListener());
        shuffleButton.setOnClickListener(new ImageListener());
        previousButton.setOnClickListener(new ImageListener());
        playButton.setOnClickListener(new ImageListener());
        nextButton.setOnClickListener(new ImageListener());

        if(fragmentCommunicator.isMusicPlaying()){
            playButton.setImageResource(R.drawable.ic_pause);
        }else{
            playButton.setImageResource(R.drawable.ic_play);
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if(input){
                    fragmentCommunicator.setSeekbarProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        getActivity().runOnUiThread(updateTimeTask);

        return view;
    }

