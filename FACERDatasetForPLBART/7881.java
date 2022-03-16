    public String exportToEncriptedString() {
        try {
            return encrypt( seed, getUserName() + ":" + getPassword() );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

