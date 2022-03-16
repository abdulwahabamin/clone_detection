    private final void populateControls() {
        try {
            View pv = findViewById( R.id.perms );
            if( pv != null ) {
                TextView fnv = (TextView)pv.findViewById( R.id.file_name );
                fnv.setText( file_path );
                {
                    urc = (CheckBox)pv.findViewById( R.id.UR );
                    if( p.ur ) urc.setChecked( true );
                    uwc = (CheckBox)pv.findViewById( R.id.UW );
                    if( p.uw ) uwc.setChecked( true );
                    uxc = (CheckBox)pv.findViewById( R.id.UX );
                    usc = (CheckBox)pv.findViewById( R.id.US );
                    if( p.ux ) uxc.setChecked( true );
                    if( p.us ) usc.setChecked( true );
                } {
                    grc = (CheckBox)pv.findViewById( R.id.GR );
                    if( p.gr ) grc.setChecked( true );
                    gwc = (CheckBox)pv.findViewById( R.id.GW );
                    if( p.gw ) gwc.setChecked( true );
                    gxc = (CheckBox)pv.findViewById( R.id.GX );
                    gsc = (CheckBox)pv.findViewById( R.id.GS );
                    if( p.gx ) gxc.setChecked( true );
                    if( p.gs ) gsc.setChecked( true );
                } {
                    orc = (CheckBox)pv.findViewById( R.id.OR );
                    if( p.or ) orc.setChecked( true );
                    owc = (CheckBox)pv.findViewById( R.id.OW );
                    if( p.ow ) owc.setChecked( true );
                    oxc = (CheckBox)pv.findViewById( R.id.OX );
                    otc = (CheckBox)pv.findViewById( R.id.OT );
                    if( p.ox ) oxc.setChecked( true );
                    if( p.ot ) otc.setChecked( true );
                } {
                    ue = (EditText)pv.findViewById( R.id.user_edit );
                    ge = (EditText)pv.findViewById( R.id.group_edit );
                    ue.setText( p.user );
                    ge.setText( p.group );
                }
                Button ob = (Button)pv.findViewById( R.id.ok );
                Button cb = (Button)pv.findViewById( R.id.cancel );
                ob.setOnClickListener( this );
                cb.setOnClickListener( this );
            }
        } catch( Exception e ) {
            Log.e( TAG, "file: " + file_path, e );
        }
    }

