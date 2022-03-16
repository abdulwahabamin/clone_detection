    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setAppShortcuts();
        logo=findViewById(R.id.logo);
        textView=findViewById(R.id.text);
        logo.setAlpha(0.0f);
        textView.setAlpha(0.0f);
        logo.animate().alpha(1.0f).setDuration(1000);
        textView.animate().alpha(1.0f).setDuration(2000).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {



                if(sharedPreferences.getString(Util.START_UP_FLAG,"").equals("")){
                    Intent i=new Intent(SplashScreen.this, Intro.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i=new Intent(SplashScreen.this,Home.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(4000);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        sharedPreferences=getSharedPreferences(Util.DIR_DATA, Context.MODE_PRIVATE);

    }

