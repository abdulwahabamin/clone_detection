    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.streamstarter);
        
        TextView tv = (TextView) findViewById(R.id.streamloading);
        
        Uri uri = getIntent().getData();
        String msg = getString(R.string.streamloadingtext, uri.getHost());
        tv.setText(msg);
    }

