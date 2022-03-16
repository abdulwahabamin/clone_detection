    @Override 
    public void onProgressChanged( SeekBar seekBar, int progress, boolean fromUser ) {
        if( !fromUser ) return;
        int id = seekBar.getId();
        switch( id ) {
        case R.id.r_seek: 
            curColor = Color.rgb( progress, Color.green( curColor ), Color.blue( curColor ) );
            break;
        case R.id.g_seek: 
            curColor = Color.rgb( Color.red( curColor ), progress, Color.blue( curColor ) );
            break;
        case R.id.b_seek: 
            curColor = Color.rgb( Color.red( curColor ), Color.green( curColor ), progress );
            break;
        }
        preview.setBackgroundColor( curColor );
    }

