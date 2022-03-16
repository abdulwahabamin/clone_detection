    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gridView.getAdapter() == null)
            return false;
        itemCount = gridView.getAdapter().getCount();
        if (itemCount == 0)
            return false;
        if (event.getActionMasked() == MotionEvent.ACTION_CANCEL) {
            if (type == TYPE_POPUP || type == TYPE_INDICATOR) {
                scrollIndicatorTextView.startAnimation(fadeOutAnimation);
            } else {
                if (type == TYPE_INDICATOR_WITH_HANDLE || type == TYPE_POPUP_WITH_HANDLE)
                    handleBar.setSelected(false);
                scrollIndicator.startAnimation(fadeOutAnimation);
            }
        }
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                //Pause image loading.
                if (picasso!=null)
                    picasso.interruptDispatching();

                if (type == TYPE_INDICATOR || type == TYPE_INDICATOR_WITH_HANDLE) {
                    scrollIndicator.startAnimation(fadeInAnimation);
                    scrollIndicator.setPadding(0, 0, getWidth(), 0);
                } else
                    scrollIndicatorTextView.startAnimation(fadeInAnimation); scroll(event.getY());
                isScrolling = true;
                return true;
            case MotionEvent.ACTION_MOVE:
                scroll(event.getY());
                return true;
            case MotionEvent.ACTION_UP:
                //Resume image loading.
                if (picasso!=null)
                    picasso.continueDispatching();

                if (type == TYPE_INDICATOR_WITH_HANDLE || type == TYPE_POPUP_WITH_HANDLE)
                    handleBar.setSelected(false);
                if (type == TYPE_INDICATOR || type == TYPE_INDICATOR_WITH_HANDLE)
                    scrollIndicator.startAnimation(fadeOutAnimation);
                else
                    scrollIndicatorTextView.startAnimation(fadeOutAnimation);
                return true;
            default:
                return false;
        }
    }

