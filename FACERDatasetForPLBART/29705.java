  /**
   * Set text of textView with html format of html parameter
   *
   * @param textView instance {@link TextView}
   * @param html     String
   */
  @SuppressLint("ClickableViewAccessibility")
  public static void setTextWithLinks(TextView textView, CharSequence html) {
    textView.setText(html);
    textView.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_UP ||
            action == MotionEvent.ACTION_DOWN) {
          int x = (int) event.getX();
          int y = (int) event.getY();

          TextView widget = (TextView) v;
          x -= widget.getTotalPaddingLeft();
          y -= widget.getTotalPaddingTop();

          x += widget.getScrollX();
          y += widget.getScrollY();

          Layout layout = widget.getLayout();
          int line = layout.getLineForVertical(y);
          int off = layout.getOffsetForHorizontal(line, x);

          ClickableSpan[] link = Spannable.Factory.getInstance()
              .newSpannable(widget.getText())
              .getSpans(off, off, ClickableSpan.class);

          if (link.length != 0) {
            if (action == MotionEvent.ACTION_UP) {
              link[0].onClick(widget);
            }
            return true;
          }
        }
        return false;
      }
    });
  }

