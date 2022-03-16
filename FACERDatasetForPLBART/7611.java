    /**
     * @return 0 - nothing selected, 1 - a file, -1 - a folder, otherwise the number 
    public final int getNumItemsSelectedOrChecked() {
    	int checked = getNumItemsChecked();
    	return checked;
    }
     */
    public final Uri getFolderUriWithAuth( boolean active ) {
        CommanderAdapter ca = getListAdapter( active );
        Uri u = ca.getUri();
        if( u != null ) {
            Credentials crd = ca.getCredentials();
            if( crd != null )
                return Utils.getUriWithAuth( u, crd );
        }
        return u; 
    }

