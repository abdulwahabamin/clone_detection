    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Context.
        mContext = getApplicationContext();
        mApp = (Common) mContext.getApplicationContext();
        mFragment = this;

        setTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_equalizer);

        //Equalizer container elements.
        mScrollView = (ScrollView) findViewById(R.id.equalizerScrollView);
        mScrollView.setBackgroundColor(UIElementsHelper.getBackgroundColor(mContext));

        //50Hz equalizer controls.
        equalizer50HzSeekBar = (VerticalSeekBar) findViewById(R.id.equalizer50Hz);
        text50HzGainTextView = (TextView) findViewById(R.id.text50HzGain);
        text50Hz = (TextView) findViewById(R.id.text50Hz);

        //130Hz equalizer controls.
        equalizer130HzSeekBar = (VerticalSeekBar) findViewById(R.id.equalizer130Hz);
        text130HzGainTextView = (TextView) findViewById(R.id.text130HzGain);
        text130Hz = (TextView) findViewById(R.id.text130Hz);

        //320Hz equalizer controls.
        equalizer320HzSeekBar = (VerticalSeekBar) findViewById(R.id.equalizer320Hz);
        text320HzGainTextView = (TextView) findViewById(R.id.text320HzGain);
        text320Hz = (TextView) findViewById(R.id.text320Hz);

        //800Hz equalizer controls.
        equalizer800HzSeekBar = (VerticalSeekBar) findViewById(R.id.equalizer800Hz);
        text800HzGainTextView = (TextView) findViewById(R.id.text800HzGain);
        text800Hz = (TextView) findViewById(R.id.text800Hz);

        //2kHz equalizer controls.
        equalizer2kHzSeekBar = (VerticalSeekBar) findViewById(R.id.equalizer2kHz);
        text2kHzGainTextView = (TextView) findViewById(R.id.text2kHzGain);
        text2kHz = (TextView) findViewById(R.id.text2kHz);

        //5kHz equalizer controls.
        equalizer5kHzSeekBar = (VerticalSeekBar) findViewById(R.id.equalizer5kHz);
        text5kHzGainTextView = (TextView) findViewById(R.id.text5kHzGain);
        text5kHz = (TextView) findViewById(R.id.text5kHz);

        //12.5kHz equalizer controls.
        equalizer12_5kHzSeekBar = (VerticalSeekBar) findViewById(R.id.equalizer12_5kHz);
        text12_5kHzGainTextView = (TextView) findViewById(R.id.text12_5kHzGain);
        text12_5kHz = (TextView) findViewById(R.id.text12_5kHz);

        //Equalizer preset controls.
        loadPresetButton = (RelativeLayout) findViewById(R.id.loadPresetButton);
        saveAsPresetButton = (RelativeLayout) findViewById(R.id.saveAsPresetButton);
        resetAllButton = (RelativeLayout) findViewById(R.id.resetAllButton);
        loadPresetText = (TextView) findViewById(R.id.load_preset_text);
        savePresetText = (TextView) findViewById(R.id.save_as_preset_text);
        resetAllText = (TextView) findViewById(R.id.reset_all_text);

        //Audio FX elements.
        virtualizerSeekBar = (SeekBar) findViewById(R.id.virtualizer_seekbar);
        bassBoostSeekBar = (SeekBar) findViewById(R.id.bass_boost_seekbar);
        reverbSpinner = (Spinner) findViewById(R.id.reverb_spinner);
        virtualizerTitle = (TextView) findViewById(R.id.virtualizer_title_text);
        bassBoostTitle = (TextView) findViewById(R.id.bass_boost_title_text);
        reverbTitle = (TextView) findViewById(R.id.reverb_title_text);

        text50HzGainTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text130HzGainTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text320HzGainTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text800HzGainTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text2kHzGainTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text5kHzGainTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text12_5kHzGainTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text50Hz.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text130Hz.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text320Hz.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text800Hz.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text2kHz.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text5kHz.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        text12_5kHz.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));

        loadPresetText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Bold"));
        savePresetText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Bold"));
        resetAllText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Bold"));

        text50HzGainTextView.setPaintFlags(text50HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text130HzGainTextView.setPaintFlags(text130HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text320HzGainTextView.setPaintFlags(text320HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text800HzGainTextView.setPaintFlags(text130HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text2kHzGainTextView.setPaintFlags(text320HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text5kHzGainTextView.setPaintFlags(text130HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text12_5kHzGainTextView.setPaintFlags(text320HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text50Hz.setPaintFlags(text50Hz.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text130Hz.setPaintFlags(text130Hz.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text320Hz.setPaintFlags(text320Hz.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text800Hz.setPaintFlags(text800Hz.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text2kHz.setPaintFlags(text2kHz.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text5kHz.setPaintFlags(text5kHz.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        text12_5kHz.setPaintFlags(text12_5kHz.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        loadPresetText.setPaintFlags(text50HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        savePresetText.setPaintFlags(text50HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        resetAllText.setPaintFlags(text50HzGainTextView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        text50HzGainTextView.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text130HzGainTextView.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text320HzGainTextView.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text800HzGainTextView.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text2kHzGainTextView.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text5kHzGainTextView.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text12_5kHzGainTextView.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text50Hz.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text130Hz.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text320Hz.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text800Hz.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text2kHz.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text5kHz.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        text12_5kHz.setTextColor(UIElementsHelper.getSmallTextColor(mContext));

        //Init reverb presets.
        ArrayList<String> reverbPresets = new ArrayList<String>();
        reverbPresets.add("None");
        reverbPresets.add("Large Hall");
        reverbPresets.add("Large Room");
        reverbPresets.add("Medium Hall");
        reverbPresets.add("Medium Room");
        reverbPresets.add("Small Room");
        reverbPresets.add("Plate");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, reverbPresets);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reverbSpinner.setAdapter(dataAdapter);

        //Set the max values for the seekbars.
        virtualizerSeekBar.setMax(1000);
        bassBoostSeekBar.setMax(1000);

        virtualizerTitle.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        virtualizerTitle.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        virtualizerTitle.setPaintFlags(virtualizerTitle.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);

        bassBoostTitle.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        bassBoostTitle.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        bassBoostTitle.setPaintFlags(bassBoostTitle.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);

        reverbTitle.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
        reverbTitle.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
        reverbTitle.setPaintFlags(reverbTitle.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);

        resetAllButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //Reset all sliders to 0.
                equalizer50HzSeekBar.setProgressAndThumb(16);
                equalizer130HzSeekBar.setProgressAndThumb(16);
                equalizer320HzSeekBar.setProgressAndThumb(16);
                equalizer800HzSeekBar.setProgressAndThumb(16);
                equalizer2kHzSeekBar.setProgressAndThumb(16);
                equalizer5kHzSeekBar.setProgressAndThumb(16);
                equalizer12_5kHzSeekBar.setProgressAndThumb(16);
                virtualizerSeekBar.setProgress(0);
                bassBoostSeekBar.setProgress(0);
                reverbSpinner.setSelection(0, false);

                //Apply the new setings to the service.
                applyCurrentEQSettings();

                //Show a confirmation toast.
                Toast.makeText(mContext, R.string.eq_reset, Toast.LENGTH_SHORT).show();

            }

        });

        loadPresetButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buildLoadPresetDialog().show();

            }

        });

        saveAsPresetButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buildSavePresetDialog().show();

            }

        });

        equalizer50HzSeekBar.setOnSeekBarChangeListener(equalizer50HzListener);
        equalizer130HzSeekBar.setOnSeekBarChangeListener(equalizer130HzListener);
        equalizer320HzSeekBar.setOnSeekBarChangeListener(equalizer320HzListener);
        equalizer800HzSeekBar.setOnSeekBarChangeListener(equalizer800HzListener);
        equalizer2kHzSeekBar.setOnSeekBarChangeListener(equalizer2kHzListener);
        equalizer5kHzSeekBar.setOnSeekBarChangeListener(equalizer5kHzListener);
        equalizer12_5kHzSeekBar.setOnSeekBarChangeListener(equalizer12_5kHzListener);

        virtualizerSeekBar.setOnSeekBarChangeListener(virtualizerListener);
        bassBoostSeekBar.setOnSeekBarChangeListener(bassBoostListener);
        reverbSpinner.setOnItemSelectedListener(reverbListener);

        //Get the saved equalizer settings and apply them to the UI elements.
        new AsyncInitSlidersTask().execute();

    }

