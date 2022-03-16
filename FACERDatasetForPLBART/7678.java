    @Override
    public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
        if( isChecked ) {
            curColor = 0;
            sliders.setVisibility( View.GONE );
        } else {
            if( curColor == 0 ) {
                curColor = defColor;
                r_seek.setProgress( Color.red( curColor ) );
                g_seek.setProgress( Color.green( curColor ) );
                b_seek.setProgress( Color.blue( curColor ) );
            }
            preview.setBackgroundColor( curColor );
            sliders.setVisibility( View.VISIBLE );
        }
    }

