    private void init(Context context) {
        View view=View.inflate(context,R.layout.sunshine_day,null);
        addView(view);
        birdup_imageview = (ImageView) view.findViewById(R.id.birdup_imageview);
        cloud_imageview = (ImageView) view.findViewById(R.id.cloud_imageview);
        sunshine_imageview = (ImageView) view.findViewById(R.id.sunshine_imageview);
        birddown_imageview = (ImageView) view.findViewById(R.id.birddown_imageview);

        birdup_animdraw = (AnimationDrawable) birdup_imageview.getDrawable();
        birdup_tweenanim = AnimationUtils.loadAnimation(context, R.anim.birdup_tweenanimation);
        birddown_animdraw = (AnimationDrawable) birddown_imageview.getDrawable();
        cloud_animation = AnimationUtils.loadAnimation(context, R.anim.cloud_animation);
        sunshine_animation = AnimationUtils.loadAnimation(context, R.anim.sunshine_animation);
        sunshine_animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                sunshine_imageview.clearAnimation();
                sunshine_imageview.startAnimation(sunshine_animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        startAnim();
    }

