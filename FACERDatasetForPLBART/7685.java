    @Override
    public void onClick( View bv ) {
        try {
            if( bv.getId() == R.id.ok ) {
                Permissions np = new Permissions( null ); 
                np.ur = urc.isChecked(); 
                np.uw = uwc.isChecked(); 
                np.ux = uxc.isChecked(); 
                np.us = usc.isChecked(); 
                np.gr = grc.isChecked(); 
                np.gw = gwc.isChecked(); 
                np.gx = gxc.isChecked(); 
                np.gs = gsc.isChecked(); 
                np.or = orc.isChecked(); 
                np.ow = owc.isChecked(); 
                np.ox = oxc.isChecked(); 
                np.ot = otc.isChecked();
                np.user  = ue.getText().toString();
                np.group = ge.getText().toString();
                String cmd = null;
                StringBuilder a = p.generateChownString( np );
                if( a != null && a.length() > 0 ) {
                    a.append( " '" ).append( file_path ).append( "'\n" );
                    cmd = "chown " + a.toString();
                }
                a = p.generateChmodString( np );
                if( a != null && a.length() > 0 ) {
                    a.append( " '" ).append( file_path ).append( "'" );
                    if( cmd == null ) cmd = "";
                    cmd += "busybox chmod " + a.toString();
                }
                if( cmd != null ) {
                    ExecEngine ee = new ExecEngine( this, new DoneHandler(), null, cmd, false, 500 );
                    ee.start();
                }
            }
            else {
                setResult( RESULT_CANCELED );
                finish();
            }
        } catch( Exception e ) {
            Log.e( TAG, "file: " + file_path, e );
        }
    }

