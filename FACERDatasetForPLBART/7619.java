    public final void copyFiles( String dest, boolean move ) {
        try {
            if( dest == null ) return;
            SparseBooleanArray items = getSelectedOrChecked();
            CommanderAdapter cur_adapter = getListAdapter( true );
            Uri dest_uri = Uri.parse( dest );
            if( Favorite.isPwdScreened( dest_uri ) ) {
                dest_uri = Favorite.borrowPassword( dest_uri, getFolderUriWithAuth( false ) );
                if( dest_uri == null ) {
                    c.showError( c.getString( R.string.inv_dest ) );
                    return;
                }
            }
            if( getNumItemsSelectedOrChecked() == 1 ) {
                int pos = getSelection( true ); 
                if( pos <= 0 ) return;
                final char SLC = File.separator.charAt( 0 );
                final boolean COPY = true;
                if( dest.indexOf( SLC ) < 0 ) { // only the file name is specified 
                    cur_adapter.renameItem( pos, dest, COPY );
                    return;
                }
                if( dest.charAt( 0 ) == SLC ) { // local FS only 
                    File dest_file = new File( dest );
                    if( dest_file.isFile() && !dest_file.isDirectory() ) {
                        cur_adapter.renameItem( pos, dest, COPY );
                        return;
                    }
                }
            }

            CommanderAdapter oth_adapter = getListAdapter( false );
            if( oth_adapter == null || !dest.equals( Favorite.screenPwd( oth_adapter.toString() ) ) ) {
                if( dest_uri == null ) {
                    c.showError( c.getString( R.string.inv_dest ) );
                    return;
                }
                String scheme = dest_uri.getScheme();
                int type_id = CA.GetAdapterTypeId( scheme );
                oth_adapter = CA.CreateAdapter( type_id, c );
                if( oth_adapter == null ) {
                    c.showError( c.getString( R.string.inv_dest ) );
                    return;
                }
                oth_adapter.setUri( dest_uri );
            }
            //c.showDialog( Dialogs.PROGRESS_DIALOG );
            destAdapter = oth_adapter;
            cur_adapter.copyItems( items, destAdapter, move );
            // TODO: getCheckedItemPositions() returns an empty array after a failed operation. why? 
            list[current].flv.clearChoices();
        }
        catch( Exception e ) {
            Log.e( TAG, "copyFiles()", e );
        }
    }

