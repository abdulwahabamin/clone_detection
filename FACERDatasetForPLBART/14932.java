    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        // Landscape mode on phone isn't ready
        if (!ApolloUtils.isTablet(this))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ApolloUtils.showUpTitleOnly(getActionBar());

        // Layout
        setContentView(R.layout.simple_eq);
        bBoost =  (SeekBar)findViewById(R.id.simple_eq_bassboost);
        bBoost.setOnSeekBarChangeListener(this);
        bBoostEnable = (CheckBox)findViewById(R.id.simple_eq_bass);
        bBoostEnable.setOnCheckedChangeListener(this);

        eQEnable = (CheckBox)findViewById(R.id.simple_eq_equalizer);
        eQEnable.setOnCheckedChangeListener(this);
        SeekBars[0]  = (VerticalSeekBar)findViewById(R.id.simple_eq_band0_seek);
        SeekBars[0].setOnSeekBarChangeListener(this);
        SeekBarLabels[0] = (TextView)findViewById(R.id.simple_eq_band0);
        SeekBars[1]  = (VerticalSeekBar)findViewById(R.id.simple_eq_band1_seek);
        SeekBars[1].setOnSeekBarChangeListener(this);
        SeekBarLabels[1] = (TextView)findViewById(R.id.simple_eq_band1);
        SeekBars[2]  = (VerticalSeekBar)findViewById(R.id.simple_eq_band2_seek);
        SeekBars[2].setOnSeekBarChangeListener(this);
        SeekBarLabels[2] = (TextView)findViewById(R.id.simple_eq_band2);
        SeekBars[3]  = (VerticalSeekBar)findViewById(R.id.simple_eq_band3_seek);
        SeekBars[3].setOnSeekBarChangeListener(this);
        SeekBarLabels[3] = (TextView)findViewById(R.id.simple_eq_band3);
        SeekBars[4]  = (VerticalSeekBar)findViewById(R.id.simple_eq_band4_seek);
        SeekBars[4].setOnSeekBarChangeListener(this);
        SeekBarLabels[4] = (TextView)findViewById(R.id.simple_eq_band4);
        SeekBars[5]  = (VerticalSeekBar)findViewById(R.id.simple_eq_band5_seek);
        SeekBars[5].setOnSeekBarChangeListener(this);
        SeekBarLabels[5] = (TextView)findViewById(R.id.simple_eq_band5);
        
        mPreferences = getSharedPreferences(APOLLO_PREFERENCES, MODE_WORLD_READABLE
                | MODE_WORLD_WRITEABLE);
        
        initEqualizerValues();
        
    }

