    /**
     * Initializes the visual components / the view.
     */
    private void initialize() {
        // Constants
        final int MAX_EDGE_LENGTH_IN_KM = 150;
        final int MIN_EDGE_LENGTH_IN_KM = 20;
        final int MAX_NUMBER_OF_RETURNS = 10;
        final int MIN_NUMBER_OF_RETURNS = 2;
        final int DEFAULT_NUMBER_OF_RETURNS = 3;
        final String FORMAT_EDGE_LENGTH_VALUE = "%s %s";

        // Values which are necessary down below
        prefManager = new AppPreferencesManager(PreferenceManager.getDefaultSharedPreferences(this));
        edgeRange = Math.round(prefManager.convertDistanceFromKilometers(MAX_EDGE_LENGTH_IN_KM - MIN_EDGE_LENGTH_IN_KM));
        minEdgeLength = Math.round(prefManager.convertDistanceFromKilometers(MIN_EDGE_LENGTH_IN_KM));
        numberOfReturnsRange = MAX_NUMBER_OF_RETURNS - MIN_NUMBER_OF_RETURNS;
        minNumberOfReturns = MIN_NUMBER_OF_RETURNS;

        // Visual components
        cityTextViewGenerator = new AutoCompleteCityTextViewGenerator(this, dbHelper);
        edtLocation = (AutoCompleteTextView) findViewById(R.id.radius_search_edt_location);
        cityTextViewGenerator.generate(edtLocation, LIMIT_LENGTH, EditorInfo.IME_ACTION_SEARCH, new MyConsumer<City>() {
            @Override
            public void accept(City city) {
                dropdownSelectedCity = city;
                enableOkButton(city != null);
            }
        }, new Runnable() {
            @Override
            public void run() {
                handleOnButtonSearchClick();
            }
        });

        //generator.getInstance(edtLocation, 8, dropdownSelectedCity);
//        edtLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                dropdownSelectedCity = (City) parent.getItemAtPosition(position);
//                // Also close the keyboard
//                InputMethodManager imm =
//                        (InputMethodManager) getApplicationContext().getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
//            }
//        });

        sbEdgeLength = (SeekBar)

                findViewById(R.id.radius_search_sb_edge_length);

        tvEdgeLengthValue = (TextView)

                findViewById(R.id.radius_search_tv_edge_length_value);

        sbNumReturns = (SeekBar)

                findViewById(R.id.radius_search_sb_num_returns);

        tvNumReturnsValue = (TextView)

                findViewById(R.id.radius_search_tv_num_returns_value);

        btnSearch = (Button)

                findViewById(R.id.radius_search_btn_search);

        // Set properties of seek bars and the text of the corresponding text views
        sbEdgeLength.setMax(edgeRange);
        sbEdgeLength.setProgress(((edgeRange + minEdgeLength) >> 1) - minEdgeLength);
        tvEdgeLengthValue.setText(
                String.format(FORMAT_EDGE_LENGTH_VALUE, sbEdgeLength.getProgress() + minEdgeLength, prefManager.getDistanceUnit())
        );

        sbNumReturns.setMax(numberOfReturnsRange);
        sbNumReturns.setProgress(DEFAULT_NUMBER_OF_RETURNS - minNumberOfReturns);
        tvNumReturnsValue.setText(String.valueOf(sbNumReturns.getProgress() + minNumberOfReturns));

        // On change of the seek bars set the text of the corresponding text views
        sbEdgeLength.setOnSeekBarChangeListener(new

                OnSeekBarEdgeLengthChange()

        );
        sbNumReturns.setOnSeekBarChangeListener(new

                OnSeekBarNumberOfReturnsChange()

        );

        // Set the click event on the button
        btnSearch.setOnClickListener(new View.OnClickListener()

                                     {
                                         @Override
                                         public void onClick(View v) {
                                             handleOnButtonSearchClick();
                                         }
                                     }

        );
    }

