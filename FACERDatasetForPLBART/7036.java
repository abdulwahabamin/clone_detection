    public final static CommanderAdapter CreateAdapter( int type_id, Commander c ) {
        CommanderAdapter ca = CreateAdapterInstance( type_id, c.getContext() );
        if( ca != null )
            ca.Init( c );
        else {
            if( type_id == SMB  )
                c.showDialog( Dialogs.SMB_PLG_DIALOG );
        }
        return ca;
    }    

