    @Override
    public Credentials getCredentials() {
        if( theUserPass == null || theUserPass.isNotSet() )
            return null;
        return theUserPass;
    }

