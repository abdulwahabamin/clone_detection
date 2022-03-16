    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sp = PreferenceManager.getDefaultSharedPreferences(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Toolbar toolbar = findViewById(R.id.graph_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTheme(theme = getTheme(sp.getString("theme", "fresh")));
        darkTheme = theme == R.style.AppTheme_NoActionBar_Dark ||
                theme == R.style.AppTheme_NoActionBar_Black ||
                theme == R.style.AppTheme_NoActionBar_Classic_Dark ||
                theme == R.style.AppTheme_NoActionBar_Classic_Black;

        if (darkTheme) {
            toolbar.setPopupTheme(R.style.AppTheme_PopupOverlay_Dark);
            labelColor = "#FFFFFF";
            lineColor = "#FAFAFA";
            backgroundBarColor = "#FFFFFF";

            TextView temperatureTextView = findViewById(R.id.graph_temperature_textview);
            temperatureTextView.setTextColor(Color.parseColor(labelColor));

            TextView rainTextView = findViewById(R.id.graph_rain_textview);
            rainTextView.setTextColor(Color.parseColor(labelColor));

            TextView pressureTextView = findViewById(R.id.graph_pressure_textview);
            pressureTextView.setTextColor(Color.parseColor(labelColor));

            TextView windSpeedTextView = findViewById(R.id.graph_windspeed_textview);
            windSpeedTextView.setTextColor(Color.parseColor(labelColor));

            TextView humidityTextView = findViewById(R.id.graph_humidity_textview);
            humidityTextView.setTextColor(Color.parseColor(labelColor));
        }

        gridPaint.setColor(Color.parseColor(lineColor));

        String lastLongterm = sp.getString("lastLongterm", "");

        if (parseLongTermJson(lastLongterm) == ParseResult.OK) {
            temperatureGraph();
            rainGraph();
            pressureGraph();
            windSpeedGraph();
            humidityGraph();
        } else {
            Snackbar.make(findViewById(android.R.id.content), R.string.msg_err_parsing_json, Snackbar.LENGTH_LONG).show();
        }
    }

