    RGBPickerDialog( Context context, ResultSink sink, int color, int def_color ) {
        super(context);
        colorChangeSink = sink;
        curColor = color;
        defColor = def_color;
        Context c = getContext();
        setTitle( c.getString( R.string.pick_color ) );
        LayoutInflater factory = LayoutInflater.from( c );
        setView( factory.inflate( R.layout.rgb, null ) );
        setButton( BUTTON_POSITIVE, c.getString( R.string.dialog_ok ), this);
        setButton( BUTTON_NEGATIVE, c.getString( R.string.dialog_cancel ), this );
    }

