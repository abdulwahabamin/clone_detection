    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeLayout = (RelativeLayout)findViewById(R.id.welcomeLayout);
        ImageView welcomeImage = (ImageView) findViewById(R.id.welcomeImage);
        welcomeImage.setImageResource(R.drawable.bluetooth1);
        contButton = (Button) findViewById(R.id.contButton);
        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Interest.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                Welcome.this.finish();
                v.getContext().startActivity(i);
            }
        });
    }

