    public SystemChromeFader(Activity activity) {
      this.activity = activity;
      statusBarAlpha = Color.alpha(activity.getWindow().getStatusBarColor());
      navBarAlpha = Color.alpha(activity.getWindow().getNavigationBarColor());
      fadeNavBar = AppUtil.isNavBarOnBottom(activity);
    }

