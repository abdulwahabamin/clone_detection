    @Override // DialogInterface.OnClickListener
    public void onClick( DialogInterface dialog, int which ) {
        if( which == BUTTON_POSITIVE && sink != null )
            sink.selZoneChanged( atRight, width );
        dismiss();
    }

