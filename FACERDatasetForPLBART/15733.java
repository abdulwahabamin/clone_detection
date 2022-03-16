    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        findViewById(R.id.peek_player).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.peek_player_play_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {play(v);
            }
        });
        findViewById(R.id.peek_player_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(v);
            }
        });
        findViewById(R.id.peek_player_prev).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev(v);
            }
        });
        

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mainFragmentSwitcher = new FragmentSwitcher(getSupportFragmentManager(), R.id.main_container);
        libraryFragment = new LibraryFragment();
        connectivityFragment = new ConnectivityFragment();

        if(getIntent().hasExtra(EXTRA_JUMP_TO_CONNECTIVITY_FRAGMENT)) {
            mainFragmentSwitcher.switchTo(connectivityFragment, CONNECTIVITY_FRAGMENT_TAG);
            getIntent().removeExtra(EXTRA_JUMP_TO_CONNECTIVITY_FRAGMENT);
        } else {
            mainFragmentSwitcher.switchTo(libraryFragment, LIBRARY_FRAGMENT_TAG);
        }

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (PlayerService.PlayerServiceBinder) service;
                initializePeekPlayer();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        peekPlayerSeekBar = (ProgressBar)findViewById(R.id.peek_player_seek_bar);
        peekPlayerSeekBar.setMax(MusicPlayer.MAX_SEEK_VALUE);
        peekPlayer = findViewById(R.id.peek_player);
        peekPlayerParent = (ViewGroup) peekPlayer.getParent();
    }

