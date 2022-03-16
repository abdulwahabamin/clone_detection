        private final int delFiles( LsItem[] list, String path ) {
            int counter = 0;
            try {
	        	for( int i = 0; i < list.length; i++ ) {
	        		if( stop || isInterrupted() ) {
	        		    error( ctx.getString( R.string.interrupted ) );
	        			break;
	        		}
	        		LsItem f = list[i];
	        		if( f != null ) {
	        			String pathName = path + f.getName();
	        			if( f.isDirectory() ) {
		                    LsItem[] subItems = ftp.getDirList( pathName );
	        				counter += delFiles( subItems, pathName + SLS );
	        				if( errMsg != null ) break;
	        	        	synchronized( ftp ) {
	        	        		ftp.clearLog();
	        	        		if( !ftp.rmDir( pathName ) ) {
		        					error( "Failed to remove folder '" + pathName + "'.\n FTP log:\n\n" + ftp.getLog() );
		        					break;
	        	        		}
	        	        	}
	        			}
	        			else {
	        				sendProgress( ctx.getString( R.string.deleting, pathName ), i * 100 / list.length );
	        	        	synchronized( ftp ) {
	        	        		ftp.clearLog();
	        	        		if( !ftp.delete( pathName ) ) {
	        	        		    error( "Failed to delete file '" + pathName + "'.\n FTP log:\n\n" + ftp.getLog() );
		        					break;
	        	        		}
	        	        	}
	        			}
	        			counter++;
	        		}
	        	}
        	}
			catch( Exception e ) {
				Log.e( TAG, "delFiles()", e );
				error( "Exception: " + e.getMessage() );
			}
            return counter;
        }

