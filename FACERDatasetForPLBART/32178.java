    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((YourLocalWeather) getApplication()).applyTheme(this);
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        Configuration.getInstance().setOsmdroidBasePath(getCacheDir());
        Configuration.getInstance().setOsmdroidTileCache(getCacheDir());
        Configuration.getInstance().setUserAgentValue(String.format("YourLocalWeather/%s (Linux; Android %s)",
                BuildConfig.VERSION_NAME,
                Build.VERSION.RELEASE));

        setContentView(R.layout.activity_search);
        setupActionBar();

        addLocatonButton = (Button) findViewById(R.id.search_add_location_button);
        addLocatonButton.setVisibility(View.GONE);

        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(this);
        List<Location> currentLocations = locationsDbHelper.getAllRows();
        Location lastLocation = currentLocations.get(currentLocations.size() - 1);

        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(11);
        GeoPoint startPoint;
        if ((lastLocation.getLongitude() == 0) && (lastLocation.getLatitude() == 0)) {
            startPoint = new GeoPoint(51.5072, -0.1267);
        } else {
            startPoint = new GeoPoint(lastLocation.getLatitude(), lastLocation.getLongitude());
        }
        mapController.setCenter(startPoint);

        resolvedLocationAddress = (TextView) findViewById(R.id.resolved_location_address);
        resolvedLocationAddress.setText(R.string.search_location_info);
        mContext = this;

        MapEventsReceiver mReceive = new MapEventsReceiver() {
            @Override
            public boolean singleTapConfirmedHelper(GeoPoint p) {

                mProgressDialog = new ProgressDialog(SearchActivity.this);
                mProgressDialog.setMessage(getString(R.string.progressDialog_gps_locate));
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setCancelable(false);
                mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            dialog.dismiss();
                        } catch (SecurityException e) {
                            appendLog(SearchActivity.this, TAG, "Cancellation error", e);
                        }
                    }
                });

                mProgressDialog.show();

                latitude = p.getLatitude();
                longitude = p.getLongitude();
                locale = PreferenceUtil.getLanguage(getApplicationContext());
                Intent resultionResult = new Intent(ACTION_ADDRESS_RESOLUTION_RESULT);
                resultionResult.setPackage("org.thosp.yourlocalweather");
                NominatimLocationService.getInstance().getFromLocation(
                        mContext,
                        p.getLatitude(),
                        p.getLongitude(),
                        1,
                        locale,
                        new SearchActivityProcessResultFromAddressResolution(mContext, resultionResult, mProgressDialog));
                return false;
            }

            @Override
            public boolean longPressHelper(GeoPoint p) {
                return false;
            }
        };

        MapEventsOverlay overlayEvents = new MapEventsOverlay(mReceive);
        map.getOverlays().add(overlayEvents);

        initializeWeatherReceiver();
    }

