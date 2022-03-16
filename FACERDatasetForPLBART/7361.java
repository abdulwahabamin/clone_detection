        public final boolean restore( Context ctx, SharedPreferences pref, int i ) {
            try {
                color = colorPref.getInt(  FGR_COL_pref + i, getDefColor( ctx, i ) );
                masks = colorPref.getString( TYPES_pref + i, getDefMasks( i ) );
                return masks != null; 
            }
            catch( Exception e ) {
            }
            return false;
        }

