  /**
   * Change string to html format
   *
   * @param htmlText String text
   * @return String text
   */
  public static CharSequence fromHtml(String htmlText) {
    if (TextUtils.isEmpty(htmlText)) {
      return null;
    }
    CharSequence spanned;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      spanned = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY);
    } else {
      spanned = Html.fromHtml(htmlText);
    }
    return trim(spanned);
  }

