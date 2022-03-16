    @Override
    public boolean onKeyDown( int keyCode, KeyEvent event ) {
        switch( keyCode ) {
        case KeyEvent.KEYCODE_BACK:
            if( dirty ) {
                DialogInterface.OnClickListener ocl = new DialogInterface.OnClickListener() {
                        public void onClick( DialogInterface dialog, int which_button ) {
                            if( which_button == DialogInterface.BUTTON_POSITIVE ) {
                                new DataSaveTask().execute( uri );
                            }
                            Editor.this.finish();
                        }
                    };
                new AlertDialog.Builder( this )
                        .setIcon( android.R.drawable.ic_dialog_alert )
                        .setTitle( R.string.save )
                        .setMessage( R.string.not_saved )
                        .setPositiveButton( R.string.save, ocl )
                        .setNegativeButton( R.string.dialog_cancel, ocl )
                        .show();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

