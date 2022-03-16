  static Interpolator getFastOutSlowInInterpolator(Context context) {
    if (fastOutSlowIn == null) {
      fastOutSlowIn = AnimationUtils.loadInterpolator(context,
          android.R.interpolator.fast_out_slow_in);
    }
    return fastOutSlowIn;
  }

