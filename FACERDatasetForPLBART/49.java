    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_animation);
        iv=(ImageView)findViewById(R.id.imageView);
        iv.setAnimation(animation);
        animation.setAnimationListener(this);
        adapter=BluetoothAdapter.getDefaultAdapter();
        new MyThread().start();
        }

