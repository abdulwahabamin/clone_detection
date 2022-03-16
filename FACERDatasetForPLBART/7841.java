    public boolean dispatchCommand( int id ) {
        switch( id ) {
        case VIEW_BOT:
            scrollView.fullScroll( View.FOCUS_DOWN );
            return true;
        case VIEW_TOP:
            scrollView.fullScroll( View.FOCUS_UP );
            return true;
        case VIEW_ENC: {
                int cen = Integer.parseInt( Utils.getEncodingDescr( this, encoding, Utils.ENC_DESC_MODE_NUMB ) );
                new AlertDialog.Builder( this )
                    .setTitle( R.string.encoding )
                    .setSingleChoiceItems( R.array.encoding, cen, new DialogInterface.OnClickListener() {
                        public void onClick( DialogInterface dialog, int i ) {
                            encoding = getResources().getStringArray( R.array.encoding_vals )[i];
                            Log.i( TAG, "Chosen encoding: " + encoding );
                            dialog.dismiss();
                            loadData();
                        }
                    }).show();
            }
            return true;
            /*
        case WRAP: 
            try {
                EditText te = (EditText)findViewById( R.id.editor );
                horScroll = horScroll ? false : true;
                te.setHorizontallyScrolling( horScroll ); 
            }
            catch( Exception e ) {
                System.err.println("Exception: " + e );
            } 
            */
        }
        return false;
    }    

