  public static void expand(final View v, final AnimListener animListener) {
    Animation a = expandAction(v);
    a.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {
      }

      @Override
      public void onAnimationEnd(Animation animation) {
        animListener.onFinish();
      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }
    });
    v.startAnimation(a);
  }

