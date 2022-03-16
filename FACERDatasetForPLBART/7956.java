    public final static String getOpReport( Context ctx, int total, int verb_id ) {
        String items = null;
        if( total > 1 ) {
            if( total < 5 )
                items = ctx.getString( R.string.items24 );
            if( items == null || items.length() == 0 )
                items = ctx.getString( R.string.items );
            if( items == null || items.length() == 0 )
                items = ctx.getString( R.string.item );
        }
        String verb = ctx.getString( verb_id );
        String report = ( total > 0 ? "" + total + " " + ( total > 1 ? items : ctx.getString( R.string.item ) ) : ctx
                .getString( R.string.nothing ) )
                + " "
                + ( total > 1 ? ctx.getString( R.string.were ) : ctx.getString( R.string.was ) )
                + " "
                + verb
                + ( total > 1 ? ctx.getString( R.string.verb_plural_sfx ) : "" ) + ".";
        return report;
    }

