  /**
   * Trim string text
   *
   * @param charSequence String text
   * @return String text
   */

  private static CharSequence trim(CharSequence charSequence) {
    if (TextUtils.isEmpty(charSequence)) {
      return charSequence;
    }
    int end = charSequence.length() - 1;
    while (Character.isWhitespace(charSequence.charAt(end))) {
      end--;
    }
    return charSequence.subSequence(0, end + 1);
  }

