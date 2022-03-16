    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weekpicker);
        getWindow().setLayout(WindowManager.LayoutParams.FILL_PARENT,
                                    WindowManager.LayoutParams.WRAP_CONTENT);

        mWeeks = (VerticalTextSpinner)findViewById(R.id.weeks);
        mWeeks.setItems(getResources().getStringArray(R.array.weeklist));
        mWeeks.setWrapAround(false);
        mWeeks.setScrollInterval(200);
        
        int def = MusicUtils.getIntPref(this, "numweeks", 2); 
        int pos = icicle != null ? icicle.getInt("numweeks", def - 1) : def - 1;
        mWeeks.setSelectedPos(pos);
        
        ((Button) findViewById(R.id.set)).setOnClickListener(mListener);
        
        ((Button) findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

