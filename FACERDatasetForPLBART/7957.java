    public final static String getHumanSize( long sz ) {
        if( sz > 1073741824 )
            return "" + Math.round( sz * 10 / 1073741824. ) / 10. + "G";
        if( sz > 1048576 )
            return "" + Math.round( sz * 10 / 1048576. ) / 10. + "M";
        if( sz > 1024 )
            return "" + Math.round( sz * 10 / 1024. ) / 10. + "K";
        return "" + sz + " ";
    }

