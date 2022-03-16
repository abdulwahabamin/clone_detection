    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        setButtonsClickListener();
        getSongs();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,songsTitles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri song = MediaStore.Audio.Media.getContentUriForPath(songsPaths.get(position));
                Toast.makeText(getApplicationContext(),song.toString(),Toast.LENGTH_LONG).show();
                //mediaPlayer.release();
                //mediaPlayer = new MediaPlayer();
                //mediaPlayer = MediaPlayer.create(getApplicationContext(),song);
                //mediaPlayer.start();
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.fatha);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(),"finish",Toast.LENGTH_LONG).show();
                seekBar.setProgress(0);
                mediaPlayer.seekTo(0);
                playPauseBtn.setBackgroundResource(R.drawable.play);
            }
        });

        seekBar.setMax(mediaPlayer.getDuration());
    }

