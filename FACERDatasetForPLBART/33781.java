    private void drawDivider(int expPosition, Canvas canvas) {
        final Drawable divider = getDivider();
        final int dividerHeight = getDividerHeight();

        if (divider != null && dividerHeight != 0) {
            final ViewGroup expItem = (ViewGroup) getChildAt(expPosition
                    - getFirstVisiblePosition());
            if (expItem != null) {
                final int left = getPaddingLeft();
                final int right = getWidth() - getPaddingRight();
                final int top;
                final int bottom;

                final int childHeight = expItem.getChildAt(0).getHeight();

                if (expPosition > mSrcPos) {
                    top = expItem.getTop() + childHeight;
                    bottom = top + dividerHeight;
                } else {
                    bottom = expItem.getBottom() - childHeight;
                    top = bottom - dividerHeight;
                }

                // Have to clip to support ColorDrawable on <= Gingerbread
                canvas.save();
                canvas.clipRect(left, top, right, bottom);
                divider.setBounds(left, top, right, bottom);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

