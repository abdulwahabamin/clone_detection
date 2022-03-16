    @Override
    public void writeToParcel( Parcel dest, int f ) {
        byte[] enc_pw = null;
        try {
            enc_pw = encrypt( getRawKey( seed.getBytes() ), getPassword().getBytes() );
        } catch( Exception e ) {
            Log.e( TAG, "on password encryption", e );
        }
        dest.writeString( getUserName() );
        dest.writeByteArray( enc_pw );
    }

