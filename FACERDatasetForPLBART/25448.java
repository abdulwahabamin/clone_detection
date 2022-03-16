    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.smithdtyler.ACTION_EXIT");
        exitReceiver = new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(TAG, "Received exit request, shutting down...");
                Intent msgIntent = new Intent(getBaseContext(), MusicPlaybackService.class);
                msgIntent.putExtra("Message", MusicPlaybackService.MSG_STOP_SERVICE);
                startService(msgIntent);
                finish();
            }

        };
        registerReceiver(exitReceiver, intentFilter);
    }

