    public void login( Credentials crd ) {
        CommanderAdapter ca = getListAdapter( true );
        if( ca != null ) {
            ca.setCredentials( crd );
            list[current].refreshList( true );
        }
    }

