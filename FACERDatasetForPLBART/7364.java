        public int getDefColor( Context ctx, int i ) {
            Resources r = ctx.getResources();
            switch( i ) {
            case 1: return r.getColor( R.color.fg1_def );
            case 2: return r.getColor( R.color.fg2_def );
            case 3: return r.getColor( R.color.fg3_def );
            case 4: return r.getColor( R.color.fg4_def );
            case 5: return r.getColor( R.color.fg5_def );
            case 6: return r.getColor( R.color.fg6_def );
            default:return r.getColor( R.color.fgr_def );
            }
        }

