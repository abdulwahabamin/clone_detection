    @SuppressLint("NewApi")
    protected void moveHandlebar(final float where) {
        float move = where;
        if (move < SCROLLBAR_MARGIN)
            move = SCROLLBAR_MARGIN;
        else if (move > getHeight() - handleBar.getHeight() - SCROLLBAR_MARGIN)
            move = getHeight() - handleBar.getHeight() - SCROLLBAR_MARGIN;

        // handleBar.setTranslationY(move);
        ViewHelper.setTranslationY(handleBar, move);
    }

