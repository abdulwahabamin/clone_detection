    public final void focus() {
        Log.v( TAG, "we set focus for this" );
        
        
        /*
         * boolean focusable = flv.isFocusable(); boolean focusable_tm =
         * flv.isFocusableInTouchMode(); boolean focused = flv.isFocused();
         * boolean item_focus = flv.getItemsCanFocus(); Log.v( TAG,
         * "wants focus. " + focusable + ", " + focusable_tm + ", " + focused +
         * ", " + item_focus );
         */
        if( flv == null ) return;
        flv.requestFocus();
        flv.requestFocusFromTouch();
    }

