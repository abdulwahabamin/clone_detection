    public final void openForEdit( String file_name ) {
        CommanderAdapter ca = getListAdapter( true );
        if( ca instanceof FavsAdapter ) {
            FavsAdapter fa = (FavsAdapter)ca;
            int pos = getSelection( true );
            if( pos > 0 ) fa.editItem( pos );
            return;
        }
        try {
            Uri u;
            if( file_name == null || file_name.length() == 0 ) {
                int pos = getSelection( true );
                CommanderAdapter.Item item = (CommanderAdapter.Item)((ListAdapter)ca).getItem( pos );
                if( item == null ) {
                    c.showError( c.getString( R.string.cant_open ) );
                    return;
                }
                if( item.dir ) {
                    c.showError( c.getString( R.string.cant_open_dir, item.name ) );
                    return;
                }
                u = ca.getItemUri( pos );
            }
            else 
                u = Uri.parse( file_name );
            if( u == null ) return;
            final String GC_EDITOR = Editor.class.getName();
            String full_class_name = null;
            String scheme = u.getScheme();
            boolean local = CA.isLocal( scheme );
            if( local )
                u = u.buildUpon().scheme( "file" ).authority( "" ).build();
            else {
                if( "root".equals( scheme ) || "smb".equals( scheme ) || "ftp".equals( scheme ) ) 
                    full_class_name = GC_EDITOR;
                else {
                    c.showMessage( c.getString( R.string.edit_err ) );
                    return;
                }
            }
            Intent i = new Intent( Intent.ACTION_EDIT );
            if( full_class_name == null ) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences( c );
                full_class_name = sharedPref.getString( "editor_activity", GC_EDITOR );
            }
            if( full_class_name.length() > 0 ) {
                int last_dot_pos = full_class_name.lastIndexOf('.');
                if( last_dot_pos < 0 ) {
                    c.showMessage( "Invalid class name: " + full_class_name );
                    full_class_name = GC_EDITOR;
                    last_dot_pos = full_class_name.lastIndexOf('.');
                }
                i.setClassName( full_class_name.substring( 0, last_dot_pos ), full_class_name );
            }
            i.setDataAndType( u, "text/plain" );
            Credentials crd = ca.getCredentials();
            if( crd != null )
                i.putExtra( Credentials.KEY, crd );
            c.startActivity( i );
        }
        catch( ActivityNotFoundException e ) {
            c.showMessage( "Activity Not Found: " + e );
        }
        catch( IndexOutOfBoundsException e ) {
            c.showMessage( "Bad activity class name: " + e );
        }
    }

