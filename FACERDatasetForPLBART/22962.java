    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();
        final String action = intent.getAction();
        final String type = intent.getType();
        // If we don't get data from intent
        if (!Intent.ACTION_SEND.equals(action) || type == null)
            return;
        // Check the type of data
        if (!"text/plain".equals(type))
            return;
        final String data = intent.getStringExtra(Intent.EXTRA_TEXT);
        // Check if it's open from youtube sharing menu and it's an video URL
        if (!isYoutubeUrl(data))
            return;
        final String apiUrl = convertUrl(data);

        Toast.makeText(this, "Getting video data...", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, DownloadService.class);
        i.putExtra("apiUrl", apiUrl);
        startService(i);
        finish();
    }

