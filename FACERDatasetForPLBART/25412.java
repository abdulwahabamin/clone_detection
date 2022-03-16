    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        previousButton = (ImageButton) findViewById(R.id.previous);
        playButton = (ImageButton) findViewById(R.id.play);
        nextButton = (ImageButton) findViewById(R.id.next);
        currentFolderText = (TextView) findViewById(R.id.current_folder);

        playButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (mPlayerService.isStarted()) {
                      if (mPlayerService.isPlaying()) {
                          Intent i = new Intent(NowplayingActivity.this, PlayerService.class);
                          i.setAction(PlayerService.ACTION_PAUSE);
                          startService(i);
                          playButton.setImageResource(android.R.drawable.ic_media_play);
                          mUpdateProgress = false;
                      } else {
                          Intent i = new Intent(NowplayingActivity.this, PlayerService.class);
                          i.setAction(PlayerService.ACTION_RESUME);
                          startService(i);
                          playButton.setImageResource(android.R.drawable.ic_media_pause);
                          mUpdateProgress = true;
                          handler.post(mUpdateRunnable);
                      }
                  } else {
                      Intent i = new Intent(NowplayingActivity.this, PlayerService.class);
                      i.setAction(PlayerService.ACTION_PLAY_TEST);
                      startService(i);
                      playButton.setImageResource(android.R.drawable.ic_media_pause);
                      mUpdateProgress = true;
                      mUpdateRunnable.run();
                  }

              }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayerService.isStarted()) {
                    Intent i = new Intent(NowplayingActivity.this, PlayerService.class);
                    i.setAction(PlayerService.ACTION_PREVIOUS);
                    startService(i);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayerService.isStarted()) {
                    Intent i = new Intent(NowplayingActivity.this, PlayerService.class);
                    i.setAction(PlayerService.ACTION_NEXT);
                    startService(i);
                }
            }
        });
    }

