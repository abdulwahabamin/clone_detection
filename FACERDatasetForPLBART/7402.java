    @Override
    public boolean onMenuItemSelected( int featureId, MenuItem item ) {
        switch( item.getItemId() ) {
        case MENU_SAVE:
            new DataSaveTask().execute( uri );
            return true;
        case MENU_SVAS: 
            try {
                LayoutInflater factory = LayoutInflater.from( this );
                View iv = factory.inflate( R.layout.input, null );
                if( iv != null ) {
                    TextView prompt = (TextView)iv.findViewById( R.id.prompt );
                    final EditText edit   = (EditText)iv.findViewById( R.id.edit_field );
                    prompt.setText( R.string.newf_prompt );
                    edit.setText( uri.toString() );
                    new AlertDialog.Builder( this )
                        .setTitle( R.string.save_as )
                        .setView( iv )
                        .setPositiveButton( R.string.save, new DialogInterface.OnClickListener() {
                            public void onClick( DialogInterface dialog, int i ) {
                                new DataSaveTask().execute( Uri.parse( edit.getText().toString() ) );
                            }
                        } ).setNegativeButton( R.string.dialog_cancel, null ).show();
                }
            } catch( Throwable e ) {
                Log.e( TAG, "", e );
            }
            return true;
        case MENU_RELD:
            new DataLoadTask().execute();
            return true;
        case MENU_ENC: {
                int cen = Integer.parseInt( Utils.getEncodingDescr( this, encoding, Utils.ENC_DESC_MODE_NUMB ) );
                new AlertDialog.Builder( this )
                    .setTitle( R.string.encoding )
                    .setSingleChoiceItems( R.array.encoding, cen, new DialogInterface.OnClickListener() {
                        public void onClick( DialogInterface dialog, int i ) {
                            dialog.dismiss();
                            encoding = getResources().getStringArray( R.array.encoding_vals )[i];
                            Log.i( TAG, "Chosen encoding: " + encoding );
                            Editor.this.showMessage( getString( R.string.encoding_set, encoding ) );
                        }
                    }).show();
            }
            return true;
        case MENU_WRAP: 
            try {
                EditText te = (EditText)findViewById( R.id.editor );
                horScroll = horScroll ? false : true;
                te.setHorizontallyScrolling( horScroll ); 
            }
            catch( Exception e ) {
                System.err.println("Exception: " + e );
            }
            return true;
        case MENU_EXIT:
            // TODO: warn if text was changed, but not saved!
            finish();
        }
        return super.onMenuItemSelected(featureId, item);
    }

