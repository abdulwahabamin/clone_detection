    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((GoodWeatherApp) getApplication()).applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        setupActionBar();

        final String path = getIntent().getData().getPath();

        setTitle(getString(R.string.title_activity_license, path.substring(24)));

        try {
            TextView licenseTextView = (TextView) findViewById(R.id.license_license_text);
            final String licenseText = readLicense(getAssets().open(path.substring(15)));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                licenseTextView.setText(Html.fromHtml(licenseText.replace("\n\n", "<br/><br/>"), Html.FROM_HTML_MODE_LEGACY));
            } else {
                licenseTextView.setText(Html.fromHtml(licenseText.replace("\n\n", "<br/><br/>")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

