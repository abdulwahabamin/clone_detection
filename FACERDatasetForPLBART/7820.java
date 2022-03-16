        public void run() {
            try {
                Log.d( TAG, "started" );
                setName( TAG );
                setPriority( Thread.MIN_PRIORITY );
                new Thread( new Runnable() {
                    @Override
                    public void run() {
                        while( true ) {
                            try {
                                synchronized( ListenThread.this ) {
                                    final int max_idle = 100000;
                                    ListenThread.this.wait( max_idle );
                                    Log.d( TAG, "Checking the idle time... last used: " + (System.currentTimeMillis()-lastUsed) + "ms ago " );
                                    if( System.currentTimeMillis() - max_idle > lastUsed ) {
                                        Log.d( TAG, "Time to closer the listen thread" );
                                        ListenThread.this.close();
                                        break;
                                    }
                                }
                            } catch( InterruptedException e ) {
                                e.printStackTrace();
                            }
                        }
                        Log.d( TAG, "Closer thread stopped" );
                    }
                }, "Closer" ).start();
                
                StreamServer.this.wifiLock.acquire();
                Log.d( TAG, "WiFi lock" );
                synchronized( this ) {
                    ss = new ServerSocket( 5322 );
                }
                int count = 0;
                while( !isInterrupted() ) {
                    Log.d( TAG, "Listening for a new connection..." );
                    Socket data_socket = ss.accept();
                    Log.d( TAG, "Connection accepted" );
                    if( data_socket != null && data_socket.isConnected() ) {
                        stream_thread = new StreamingThread( data_socket, count++ );
                        stream_thread.start();
                    }
                    touch();
                }
            }
            catch( Exception e ) {
                Log.w( TAG, "Exception", e );
            }
            finally {
                StreamServer.this.wifiLock.release();
                Log.d( TAG, "WiFi lock release" );
                this.close();
            }
            StreamServer.this.stopSelf();
        }

