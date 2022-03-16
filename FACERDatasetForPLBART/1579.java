    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        preferenceManager = new PreferenceManager(context);
        setUpButton = findViewById(R.id.set_sup_button);
        editText = findViewById(R.id.chat_username_et);
        lottieAnimationView = findViewById(R.id.empty_img);
        lottieAnimationView.setVisibility(View.VISIBLE);

        setUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getText(editText);
                preferenceManager.setUserName(name);
                checkBluetoothSupport();
            }
        });


    }

