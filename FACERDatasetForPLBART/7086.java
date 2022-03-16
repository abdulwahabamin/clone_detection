    @Override
    public int setMode( int mask, int val ) {
        /*
        if( ( mask & SET_MODE_COLORS ) != 0 ) {
            switch( mask & SET_MODE_COLORS ) {
            case SET_TXT_COLOR:
                fg_color = val;
                break;
            case SET_SEL_COLOR:
                sl_color = val;
                break;
            }
            return 0;
        }
        */
        if( ( mask & SET_FONT_SIZE ) != 0 ) {
            font_size = val;
            return 0;
        }
        if( ( mask & SET_TBN_SIZE ) != 0 ) {
            thumbnail_size_perc = val;
            calcWidths();
            return 0;
        }
        if( ( mask & ( MODE_FINGERF | MODE_ICONS ) ) != 0 )
            calcWidths();

        mode &= ~mask;
        mode |= val;
        if( mask == LIST_STATE ) {
            /*
             * Log.v( TAG, ( mode & LIST_STATE ) == STATE_IDLE ?
             * "list    I D L E  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" :
             * "list    B U S Y  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" ); //
             * Android v2.3.3 has a bug (again!)
             */
        } else
            dirty = true;
        if( ( mask & MODE_SORT_DIR ) != 0 || ( mask & MODE_SORTING ) != 0 ) {
            if( ( mask & MODE_SORT_DIR ) != 0 )
                ascending = ( val & MODE_SORT_DIR ) == SORT_ASC;
            reSort();
            notifyDataSetChanged();
        }
        return mode;
    }

