        @Override
        public void run() {
            try {
                Init( null );
                List<PackageInfo> all_packages = pm.getInstalledPackages( 0 );
                items_tmp = new PackageInfo[all_packages.size()];
                all_packages.toArray( items_tmp );
                Arrays.sort( items_tmp, new PackageInfoComparator( mode & MODE_SORTING, (mode & MODE_CASE) != 0, ascending ) );
                sendProgress( null, Commander.OPERATION_COMPLETED, pass_back_on_done );
            }
            catch( Exception e ) {
                sendProgress( "Fail", Commander.OPERATION_FAILED, pass_back_on_done );
            }
            catch( OutOfMemoryError err ) {
                sendProgress( "Out Of Memory", Commander.OPERATION_FAILED, pass_back_on_done );
            }
            finally {
                super.run();
            }
        }

