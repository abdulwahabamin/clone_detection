    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        cityCountryName = sharedPreferences.getString(CITY_COUNTRY_NAME, "");
        actvCityCountryName.setText(cityCountryName);
        //mFetchThreadData = new FetchThreadData<>(mHandler);
        //mFetchThreadData.start();
        //mFetchThreadData.getLooper();
        //initServerResponse();


        //JSONConverter.getInstance().makeNewShortJSON(this, null, null, null);

        if (database.isOpen()) {
            checkDatabaseState();
        } else {
            database = databaseHelper.getReadableDatabase();
            checkDatabaseState();
        }


        // Create a SimpleCursorAdapter for the State Name field.
        mAdapter = new SimpleCursorAdapter(this,
                R.layout.dropdown_text,
                null,
                new String[]{CITY_COUNTRY_NAME},
                new int[]{R.id.text}, 0);
        mAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                if (constraint != null) {
                    if (constraint.length() >= 3 && !TextUtils.isEmpty(constraint)) {
                        Bundle bundle = new Bundle();
                        String query = charArrayUpperCaser(constraint);
                        bundle.putString(CITY_ARGS, query);
                        getLoaderManager().restartLoader(0, bundle, MainActivity.this).forceLoad();
                    }
                }
                return null;
            }
        });

        // Set an OnItemClickListener, to update dependent fields when
        // a choice is made in the AutoCompleteTextView.
        actvCityCountryName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the
                // result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
                cityCountryName = cursor.getString(cursor.getColumnIndexOrThrow(CITY_COUNTRY_NAME));

                // Update the parent class's TextView
                actvCityCountryName.setText(cityCountryName);

                requestWeather();
                //mFetchThreadData.queueResponce(position, cityCountryName);

//                JSONWeatherTask task = new JSONWeatherTask();
//                task.execute(new String[]{cityCountryName});

                hideKeyboard();
            }
        });

        actvCityCountryName.setAdapter(mAdapter);


    }

