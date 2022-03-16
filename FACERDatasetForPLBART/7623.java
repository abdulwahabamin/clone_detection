    public final void createZip( String new_zip_name ) {
        CommanderAdapter ca = getListAdapter( true );
        if( ca instanceof FSAdapter ) {
            SparseBooleanArray cis = getSelectedOrChecked();
            if( cis == null || cis.size() == 0 ) {
                c.showError( c.getString( R.string.op_not_alwd ) );
                return;
            }
            FSAdapter fsa = (FSAdapter)ca;
            ZipAdapter z = new ZipAdapter( c );
            z.Init( c );
            destAdapter = z;
            File[] files = fsa.bitsToFiles( cis );
            z.createZip( files, Utils.mbAddSl( ca.toString() ) + new_zip_name );
        }
        else
            c.showError( c.getString( R.string.not_supported ) );
    }

