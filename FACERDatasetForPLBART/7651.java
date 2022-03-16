    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        try {
          requestWindowFeature( Window.FEATURE_NO_TITLE );
          touch = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO;
          if( touch )
              image_view = new TouchImageView( this );
          else
              image_view = new ImageView( this );
          setContentView( image_view );
        }
        catch( Throwable e ) {
            e.printStackTrace();
        }
    }

