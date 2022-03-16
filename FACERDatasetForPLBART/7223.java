        @Override
        public void run() {
        	sendProgress( ctx.getString( R.string.preparing ), 0, 0 );
        	try {
                int l = fList.length;
                FileItem[] x_list = new FileItem[l];
                for( int j = 0; j < l; j++ )
                    x_list[j] = new FileItem( fList[j] );
				long sum = getSizes( x_list );
				conv = 100 / (double)sum;
				int num = copyFiles( fList, mDest, destIsFullName );
	            String report = Utils.getOpReport( ctx, num, move ? R.string.moved : R.string.copied );
	            sendResult( report );
			} catch( Exception e ) {
				sendProgress( e.getMessage(), Commander.OPERATION_FAILED );
				return;
			}
        }

