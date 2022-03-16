    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IF_TABLE_EXITS = sharedPreferences.getBoolean(TABLE,false);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        imageView = findViewById(R.id.splash_screen);
        imageView.setVisibility(View.INVISIBLE);
        getSupportActionBar().hide();


        if (IF_TABLE_EXITS){
            Log.d(TAG, "onCreate: data base exists");
            Intent intent = new Intent(SplashScreen.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else {
            imageView.setVisibility(View.VISIBLE);
            Log.d(TAG, "onCreate: data base doesn't exits");
            createLocalCityDB();
            sharedPreferences.edit().putBoolean(TABLE, true).apply();
            Intent intent = new Intent(SplashScreen.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    }

