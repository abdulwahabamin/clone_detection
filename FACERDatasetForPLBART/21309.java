      @Override public void run() {
        if (!mFades) return;

        final int alpha = Math.max(mPaint.getAlpha() - mFadeBy, 0);
        mPaint.setAlpha(alpha);
        invalidate();
        if (alpha > 0) {
          postDelayed(this, FADE_FRAME_MS);
        }
      }

