    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgView = (ImageView)findViewById(R.id.imageView);

        Intent intent = getIntent();
        byte[] image = intent.getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
        imgView.setImageBitmap(bitmap);
    }

