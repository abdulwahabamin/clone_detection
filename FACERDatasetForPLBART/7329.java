	    private final int copyFiles( ZipEntry[] list, String path ) {
	        int counter = 0;
	        try {
	            long dir_size = 0, byte_count = 0;
	            for( int i = 0; i < list.length; i++ ) {
                    ZipEntry f = list[i];	            
                    if( !f.isDirectory() )
                        dir_size += f.getSize();
	            }
	            double conv = 100./(double)dir_size;
	        	for( int i = 0; i < list.length; i++ ) {
	        		ZipEntry entry = list[i];
	        		if( entry == null ) continue;
	        		String entry_name_fixed = fixName( entry );
	        		if( entry_name_fixed == null ) continue;
        		    String file_name = new File( entry_name_fixed ).getName();
        		    File   dest_file = new File( dest_folder, path + file_name );
        			String rel_name = entry_name_fixed.substring( base_len );
        			
        			if( entry.isDirectory() ) {
        				if( !dest_file.mkdir() ) {
        					if( !dest_file.exists() || !dest_file.isDirectory() ) {
	        					errMsg = "Can't create folder \"" + dest_file.getAbsolutePath() + "\"";
	        					break;
        					}
        				}
        				ZipEntry[] subItems = GetFolderList( entry_name_fixed );
	                    if( subItems == null ) {
	                    	errMsg = "Failed to get the file list of the subfolder '" + rel_name + "'.\n";
	                    	break;
	                    }
        				counter += copyFiles( subItems, rel_name );
        				if( errMsg != null ) break;
        			}
        			else {
                        if( dest_file.exists()  ) {
                            int res = askOnFileExist( ctx.getString( R.string.file_exist, dest_file.getAbsolutePath() ), commander );
                            if( res == Commander.ABORT ) break;
                            if( res == Commander.SKIP )  continue;
                            if( res == Commander.REPLACE ) {
                                if( !dest_file.delete() ) {
                                    error( ctx.getString( R.string.cant_del, dest_file.getAbsoluteFile() ) );
                                    break;
                                }
                            }
                        }
        				InputStream in = zip.getInputStream( entry );
        				FileOutputStream out = new FileOutputStream( dest_file );
        	            byte buf[] = new byte[BLOCK_SIZE];
        	            int  n = 0;
        	            int  so_far = (int)(byte_count * conv);
        	            
        	            String unp_msg = ctx.getString( R.string.unpacking, rel_name ); 
        	            while( true ) {
        	                n = in.read( buf );
        	                if( n < 0 ) break;
        	                out.write( buf, 0, n );
        	                byte_count += n;
        	                sendProgress( unp_msg, so_far, (int)(byte_count * conv) );
                            if( stop || isInterrupted() ) {
                                in.close();
                                out.close();
                                dest_file.delete();
                                errMsg = "File '" + dest_file.getName() + "' was not completed, delete.";
                                break;
                            }
        	            }
        			}
        			
                    final int GINGERBREAD = 9;
                    if( android.os.Build.VERSION.SDK_INT >= GINGERBREAD )
                        ForwardCompat.setFullPermissions( dest_file );
        			        			
                    if( stop || isInterrupted() ) {
                        error( ctx.getString( R.string.canceled ) );
                        break;
                    }
                    if( i >= list.length-1 )
                        sendProgress( ctx.getString( R.string.unpacked_p, rel_name ), (int)(byte_count * conv) );
        			counter++;
	        	}
	    	}
			catch( Exception e ) {
				Log.e( TAG, "copyFiles()", e );
				error( "Exception: " + e.getMessage() );
			}
	        return counter;
	    }

