    @Override
    public ParcelFileDescriptor openFile( Uri uri, String mode ) throws FileNotFoundException {
        //Log.v( TAG, "openFile( " + uri + " )" );
        File file = new File( uri.getPath() );
        if( !file.exists() ) throw new FileNotFoundException();
        ParcelFileDescriptor parcel = ParcelFileDescriptor.open( file, ParcelFileDescriptor.MODE_READ_ONLY );
        return parcel;
    }

