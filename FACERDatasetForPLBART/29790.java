  @Override
  public View makeView() {
    final TextView textView = new TextView(context);
    if (center) {
      textView.setGravity(Gravity.CENTER);
    }
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
      textView.setTextAppearance(context, styleId);
    } else {
      textView.setTextAppearance(styleId);
    }
    textView.setTypeface(typeface);
    return textView;
  }

