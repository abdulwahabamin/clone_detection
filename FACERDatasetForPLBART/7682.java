    @Override // DialogInterface.OnClickListener
    public void onClick( DialogInterface dialog, int which ) {
        if( which == BUTTON_POSITIVE && colorChangeSink != null )
            colorChangeSink.colorChanged( curColor );
        dismiss();
    }

