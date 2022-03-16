        @Override
        public int compare( PackageInfo pi1, PackageInfo pi2 ) {
            int ext_cmp = 0;
            try {
                switch( type ) {
                case CommanderAdapter.SORT_EXT:
                    if( pi1.packageName != null )
                        ext_cmp = pi1.packageName.compareTo( pi2.packageName );
                    break;
                case CommanderAdapter.SORT_SIZE:  {
                        File asdf1 = new File( pi1.applicationInfo.sourceDir );
                        File asdf2 = new File( pi2.applicationInfo.sourceDir );
                        ext_cmp = asdf1.length() - asdf2.length() < 0 ? -1 : 1;
                    }
                    break;
                case CommanderAdapter.SORT_DATE: {
                        File asdf1 = new File( pi1.applicationInfo.sourceDir );
                        File asdf2 = new File( pi2.applicationInfo.sourceDir );
                        ext_cmp = asdf1.lastModified() - asdf2.lastModified() < 0 ? -1 : 1;
                    }
                    break;
                }
                if( ext_cmp == 0 )
                    ext_cmp = aidnc.compare( pi1.applicationInfo, pi2.applicationInfo );
            } catch( Exception e ) {}
            return ascending ? ext_cmp : -ext_cmp;
        }

