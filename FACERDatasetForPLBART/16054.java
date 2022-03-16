    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate view
        rootView = inflater.inflate(R.layout.fragment_player, container, false);
        albumArtView = (ImageView) rootView.findViewById(R.id.player_album_art);

        //Set listeners for buttons
        rootView.findViewById(R.id.player_play_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {play(v);
            }
        });
        rootView.findViewById(R.id.player_next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {next(v);
            }
        });
        rootView.findViewById(R.id.player_prev_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {prev(v);
            }
        });
        rootView.findViewById(R.id.player_queue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.showQueue();
            }
        });

        //Set up seekBar variable to SeekBar in view
        seekBar = (SeekBar) this.rootView.findViewById(R.id.player_track_seek);
        seekBar.setMax(MusicPlayer.MAX_SEEK_VALUE);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int newSeek = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    newSeek = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                userSeeking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                userSeeking = false;
                binder.seek(newSeek);
            }
        });

        //Initialize serviceConnection for binding
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (PlayerService.PlayerServiceBinder) service;
                initializePlayer();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        return rootView;
    }

