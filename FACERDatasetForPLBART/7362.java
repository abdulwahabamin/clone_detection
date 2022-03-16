        public final void store( SharedPreferences.Editor editor, int i ) {
            if( colorDirty ) {
                String pref_key = FGR_COL_pref + i;
                editor.putInt( pref_key, color );
            }
            if( masksDirty ) {
                String pref_key = TYPES_pref + i;
                editor.putString( pref_key, masks );
            }
        }

