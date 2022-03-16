    @Override
    protected void onReadComplete() {
        try {
            attempts = 0;
            if( reader instanceof ListEngine ) {
                ListEngine list_engine = (ListEngine)reader;
                items = list_engine.getItems();
                uri = list_engine.getUri();
                numItems = items != null ? items.length + 1 : 1;
                notifyDataSetChanged();
                
                String path = uri.getPath();
                if( path != null && path.startsWith( SYSTEM_PATH ) ) {
                    // know the /system mount state
                    systemMountReader = new MountsListEngine( commander.getContext(), readerHandler, false );
                    systemMountReader.start();
                }
            } else
            if( systemMountReader != null ) {
                MountItem[] mounts = systemMountReader.getItems();
                if( mounts != null ) {
                    boolean remount = systemMountReader.toRemount();
                    systemMountReader = null;
                    for( MountItem m : mounts ) {
                        String mp = m.getMountPoint();
                        if( SYSTEM_PATH.equals( mp ) ) {
                            if( remount ) {
                                worker = new RemountEngine( commander.getContext(), workerHandler, m );
                                worker.start();
                            }
                            else
                                systemMountMode = m.getMode();
                            break;
                        }
                    }
                }
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

