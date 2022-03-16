    SelZoneDialog( Context c, ResultSink sink_, boolean atRight_, int width_, int sel_color_ ) {
        super( c );
        context = c;
        sink = sink_;
        width = width_;
        atRight = atRight_;
        sel_color = sel_color_;
        setTitle( c.getString( R.string.selection_zone_setup ) );
        LayoutInflater factory = LayoutInflater.from( c );
        setView( factory.inflate( R.layout.selzone, null ) );
        setButton( BUTTON_POSITIVE, c.getString( R.string.dialog_ok ),     this );
        setButton( BUTTON_NEGATIVE, c.getString( R.string.dialog_cancel ), this );
    }

