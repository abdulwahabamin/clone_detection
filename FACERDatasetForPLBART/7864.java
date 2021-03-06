    public final void restore( SharedPreferences shared_pref, Context context ) {
        String bcns = shared_pref.getString( pref_key, null );
        if( bcns != null && bcns.length() > 0 ) {
            // add new introduced buttons also here like below:
            if( bcns.indexOf( "search" ) < 0 ) bcns += ",search";
            String[] bcna = bcns.split( "," );
            for( String bcn : bcna ) {
                int bi = ToolButton.getId( bcn );
                if( bi == 0 ) continue;
                ToolButton tb = new ToolButton( bi );
                tb.restore( shared_pref, context );
                add( tb );
            }
        }
        else{
            int[] bia = { 
                 R.id.F1,      
                 R.id.F2,      
                 R.id.F3,      
                 R.id.F4,      
                 R.id.SF4,     
                 R.id.F5,      
                 R.id.F6,      
                 R.id.F7,      
                 R.id.F8,      
                 R.id.F9,      
                 R.id.F10,     
                 R.id.remount,
                 R.id.sz,      
                 R.id.eq,      
                 R.id.tgl,     
                 R.id.enter,   
                 R.id.refresh,
                 R.id.by_name, 
                 R.id.by_ext,  
                 R.id.by_size, 
                 R.id.by_date, 
                 R.id.hidden,
                 R.id.sel_all, 
                 R.id.uns_all, 
                 R.id.add_fav,  
                 R.id.home,    
                 R.id.favs,    
                 R.id.sdcard,  
                 R.id.root,   
                 R.id.mount,   
                 R.id.softkbd,   
                 R.id.search
            };
            for( int bi : bia ) {
                ToolButton tb = new ToolButton( bi );
                tb.restore( shared_pref, context );
                add( tb );
            }
        }
    }

