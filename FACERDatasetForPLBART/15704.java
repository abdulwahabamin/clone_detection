    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the song content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = SongContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            songId = mItem.id;
            try {
                if (mPlayer == null) {
                    Log.d("INFO:", "onCreate: Media Player created");
                    mPlayer = new MediaPlayer();
                } else {
                    Log.d("INFO:", "onCreate: Media Player reset");
                    if(mPlayer.isPlaying()) {
                        mPlayer.stop();
                    }
                    mPlayer.reset();
                }
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mPlayer.setDataSource(mItem.url);
                mPlayer.prepare();
                mPlayer.start();
            } catch (IOException e) {
                Log.e("ERROR: ", "onCreate: ", e);
            }

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

