    /**
     * Loads the contents of the MainActivity view and implements functionality for the various
     * components.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songList = loadAllSongs();
        playlistMap = new HashMap<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        currentTime = (TextView) findViewById(R.id.currentTime);
        totalTime = (TextView) findViewById(R.id.totalTime);
        currentSongName = (TextView) findViewById(R.id.currentSongName);
        currentSongLayout = (RelativeLayout) findViewById(R.id.currentSongLayout);
        playButton = (ImageView) findViewById(R.id.playButton);
        previousButton = (ImageView) findViewById(R.id.previousButton);
        nextButton = (ImageView) findViewById(R.id.nextButton);

        currentSongName.setSelected(true);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("All Music Tab"));
        tabLayout.addTab(tabLayout.newTab().setText("Playlists Tab"));
        tabLayout.addTab(tabLayout.newTab().setText("Bonus Tab"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                if(focusChange == AUDIOFOCUS_LOSS_TRANSIENT){
                    mediaPlayer.pause();
                    playButton.setImageResource(R.drawable.ic_play);
                }else if(focusChange == AUDIOFOCUS_GAIN){
                    mediaPlayer.start();
                    playButton.setImageResource(R.drawable.ic_pause);
                }else if(focusChange == AUDIOFOCUS_LOSS){
                    mediaPlayer.pause();
                    playButton.setImageResource(R.drawable.ic_play);
                }
            }
        };

        int audioResult = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

        if(audioResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
            mediaPlayer.start();
        }else{
            mediaPlayer.pause();
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        currentSongLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.animator_slide_up, R.animator.animator_slide_down, R.animator.animator_slide_up, R.animator.animator_slide_down);

                fragmentTransaction.replace(R.id.activity_main, musicCoverFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if(mediaPlayer != null && input){
                    mediaPlayer.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playButtonAction();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButtonAction();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousButtonAction();
            }
        });
    }

