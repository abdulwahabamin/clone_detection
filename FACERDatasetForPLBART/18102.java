    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
Intent intent=getIntent();
url=intent.getStringExtra("url");
image=intent.getStringExtra("image");
song=intent.getStringExtra("song");
artists=intent.getStringExtra("artists");
        // All player buttons
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnForward = (ImageButton) findViewById(R.id.btnForward);
        btnBackward = (ImageButton) findViewById(R.id.btnBackward);
        share = (ImageButton) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");

                    i.putExtra(Intent.EXTRA_TEXT, url);
                    startActivity(Intent.createChooser(i, "Choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });
        imageView=(ImageView)findViewById(R.id.ik);
        Glide.with(Main2Activity.this).load(image).into(imageView);
        btnRepeat = (ImageButton) findViewById(R.id.btnRepeat);
        btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);
        songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
        songTitleLabel = (TextView) findViewById(R.id.songTitle);
        songTitleLabel.setText(song);
        songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
        songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);
        artis = (TextView) findViewById(R.id.art);
        artis.setText(artists);
        // Mediaplayer
      // Important


        // By default play first song


        /**
         * Play button click event
         * plays a song and changes button to pause image
         * pauses a song and changes button to play image
         * */
        btnPlay.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View arg0) {
                                           // check for already playing
                                           final ProgressDialog mDialog = new ProgressDialog(Main2Activity.this);


                                           AsyncTask<String, String, String> mp3Play = new AsyncTask<String, String, String>() {

                                               @Override
                                               protected void onPreExecute() {
                                                   mDialog.setMessage("Please wait");
                                                   mDialog.show();
                                               }

                                               @Override
                                               protected String doInBackground(String... params) {
                                                   try {
                                                       mp.setDataSource(params[0]);
                                                       mp.prepare();
                                                   } catch (Exception ex) {

                                                   }
                                                   return "";
                                               }

                                               @Override
                                               protected void onPostExecute(String s) {
                                                   if (!mp.isPlaying()) {
                                                       mp.start();
                                                       btnPlay.setImageResource(R.drawable.ic_pause);
                                                   } else {
                                                       mp.pause();
                                                       btnPlay.setImageResource(R.drawable.ic_play);
                                                   }

                                                   updateProgressBar();
                                                   mDialog.dismiss();
                                               }
                                           };

                                           mp3Play.execute(url); // direct link mp3 file

                                           mp.start();
                                       }
                                   });
            //                if(mp.isPlaying()){
//                    if(mp!=null){
//                        mp.pause();
//                        // Changing button image to play button
//                        btnPlay.setImageResource(R.drawable.plqay);
//                    }
//                }else{
//                    // Resume song
//                    if(mp!=null){
//                        mp.start();
//                        // Changing button image to pause button
//                        btnPlay.setImageResource(R.drawable.btn_pause);
//                    }
//                }

        mp = new MediaPlayer();
        utils = new Utilities();

        // Listeners
        songProgressBar.setOnSeekBarChangeListener(this); // Important
        mp.setOnCompletionListener(this);
        /**
         * Forward button click event
         * Forwards song specified seconds
         * */
        btnForward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // get current song position
                int currentPosition = mp.getCurrentPosition();
                // check if seekForward time is lesser than song duration
                if(currentPosition + seekForwardTime <= mp.getDuration()){
                    // forward song
                    mp.seekTo(currentPosition + seekForwardTime);
                }else{
                    // forward to end position
                    mp.seekTo(mp.getDuration());
                }
            }
        });

        /**
         * Backward button click event
         * Backward song to specified seconds
         * */
        btnBackward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // get current song position
                int currentPosition = mp.getCurrentPosition();
                // check if seekBackward time is greater than 0 sec
                if(currentPosition - seekBackwardTime >= 0){
                    // forward song
                    mp.seekTo(currentPosition - seekBackwardTime);
                }else{
                    // backward to starting position
                    mp.seekTo(0);
                }

            }
        });

        /**
         * Next button click event
         * Plays next song by taking currentSongIndex + 1
         * */


        /**
         * Back button click event
         * Plays previous song by currentSongIndex - 1
         * */


        /**
         * Button Click event for Repeat button
         * Enables repeat flag to true
         * */
        btnRepeat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(isRepeat){
                    isRepeat = false;
                    Toast.makeText(getApplicationContext(), "Repeat is OFF", Toast.LENGTH_SHORT).show();
                    btnRepeat.setImageResource(R.drawable.btn_repeat);
                }else{
                    // make repeat to true
                    isRepeat = true;
                    Toast.makeText(getApplicationContext(), "Repeat is ON", Toast.LENGTH_SHORT).show();
                    // make shuffle to false
                    isShuffle = false;
                    btnRepeat.setImageResource(R.drawable.btn_repeat_focused);
                    btnShuffle.setImageResource(R.drawable.btn_shuffle);
                }
            }
        });

        /**
         * Button Click event for Shuffle button
         * Enables shuffle flag to true
         * */
        btnShuffle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(isShuffle){
                    isShuffle = false;
                    Toast.makeText(getApplicationContext(), "Shuffle is OFF", Toast.LENGTH_SHORT).show();
                    btnShuffle.setImageResource(R.drawable.btn_shuffle);
                }else{
                    // make repeat to true
                    isShuffle= true;
                    Toast.makeText(getApplicationContext(), "Shuffle is ON", Toast.LENGTH_SHORT).show();
                    // make shuffle to false
                    isRepeat = false;
                    btnShuffle.setImageResource(R.drawable.btn_shuffle_focused);
                    btnRepeat.setImageResource(R.drawable.btn_repeat);
                }
            }
        });

        /**
         * Button Click event for Play list click event
         * Launches list activity which displays list of songs
         * */


    }

