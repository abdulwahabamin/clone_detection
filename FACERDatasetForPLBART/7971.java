    public final static String getEncodingDescr( Context ctx, String enc_name, int mode ) {
        if( enc_name == null )
            enc_name = "";
        Resources res = ctx.getResources();
        if( res == null )
            return null;
        String[] enc_dsc_arr = res.getStringArray( R.array.encoding );
        String[] enc_nms_arr = res.getStringArray( R.array.encoding_vals );
        try {
            for( int i = 0; i < enc_nms_arr.length; i++ ) {
                if( enc_name.equals( enc_nms_arr[i] ) ) {
                    if( mode == ENC_DESC_MODE_NUMB )
                        return "" + i;
                    String enc_desc = enc_dsc_arr[i];
                    if( mode == ENC_DESC_MODE_FULL )
                        return enc_desc;
                    else {
                        int nlp = enc_desc.indexOf( '\n' );
                        if( nlp < 0 )
                            return enc_desc;
                        return enc_desc.substring( 0, nlp );
                    }

                }
            }
        } catch( Exception e ) {
        }
        return null;
    }

