    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        backtoNowPlaying = (Button) findViewById(R.id.backto_nowplaying);

        backtoNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QueueActivity.this, NowplayingActivity.class);
                startActivity(i);
            }
        });
    }

