        @Override
        public int compare( ActivityInfo ai1, ActivityInfo ai2 ) {
            int ext_cmp = 0;
            try {
                switch( type ) {
                case CommanderAdapter.SORT_EXT:
                    if( ai1.packageName != null )
                        ext_cmp = ai1.name.compareTo( ai2.name );
                    break;
                }
                if( ext_cmp == 0 ) {
                    String cn1 = ai1.loadLabel( pm_ ).toString();
                    String cn2 = ai2.loadLabel( pm_ ).toString();
                    ext_cmp = cn1.compareTo( cn2 );
                }
            } catch( Exception e ) {
            }
            return ascending ? ext_cmp : -ext_cmp;
        }

