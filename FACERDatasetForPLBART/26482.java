    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();
        final int oldChoose = choose;
        final OnLetterChangedListener listener = onLetterChangedListener;
        final int c = (int) (y / getHeight() * INITIAL.length);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                if (oldChoose != c && listener != null) {
                    if (c >= 0 && c < INITIAL.length) {
                        choose = c;
                        invalidate();
                        if (overlay != null) {
                            overlay.setVisibility(VISIBLE);
                            String letter = INITIAL[c];
                            if (!(c == 0 || c == 1 || letter.equals("O") || letter.equals("U") || letter.equals("V"))) {
                                listener.onLetterChanged(INITIAL[c]);
                                overlay.setText(INITIAL[c]);
                            }

                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                choose = -1;
                invalidate();
                if (overlay != null) {
                    overlay.setVisibility(GONE);
                }
                break;
        }
        return true;
    }

