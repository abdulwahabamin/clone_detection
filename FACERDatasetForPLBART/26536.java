    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView tx = (TextView) findViewById(R.id.appdesc);
        tx.setText(Html.fromHtml(getResources().getString(R.string.versionDesc)));
        findViewById(R.id.button_license).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, LicenseActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        new AlertDialog.Builder(this)
                .setTitle("Achtung")
                .setMessage("Dies ist eine Beta Version!")
                .setPositiveButton(android.R.string.ok, null).show();
    }

