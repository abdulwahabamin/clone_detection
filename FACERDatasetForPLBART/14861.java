	public void onCreate( ){
		
		//create the service
		super.onCreate();
		
		//start position is at 0
		songPosition = 0;
		
		//create player
		player= new MediaPlayer();
		
		initiateMusicPlayer();
		
		rand = new Random( );
		
		
	}

