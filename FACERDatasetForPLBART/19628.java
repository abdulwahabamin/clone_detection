    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Thread timer = new Thread() {
            public void run() {
                try {
                    // sleep(R.integer.SplashActivityTime);
                    sleep(1000);
                } catch (InterruptedException iEx) {
                    iEx.printStackTrace();
                } finally {
                    Intent mainActivity = new Intent(SettingsAudioFragment.this,
                            EqualizerActivity.class);

                    startActivity(mainActivity);
                    finish();
                }
            }
        };
        timer.start();
    }

