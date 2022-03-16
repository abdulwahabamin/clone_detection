    @Override
    public void onCheckedChanged( CompoundButton buttonView, boolean isChecked ) {
        atRight = isChecked;
        if( width_seek != null ) {
            layout.removeView( width_seek );
            width_seek = new SeekBar( context );
            Drawable sbd = createSeekBarDrawable( sel_color );
            width_seek.setProgressDrawable( sbd );
            width_seek.setOnSeekBarChangeListener( this );
            width_seek.setProgress( width );
            layout.addView( width_seek );
        }
    }

