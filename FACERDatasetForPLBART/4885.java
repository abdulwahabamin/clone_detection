	public boolean WriteSecureToSd() {
		if(EnsurePathAndFile()) {
			boolean completed=false;
			
			Writer writer=null;
			OutputStream out=null;
			try {
                //BLog.e("E1",HomeFarm.getPemKey()+"------~"+path+File.separator+filename);
				Encrypt crypt = new Encrypt(useKey!=null?useKey:HomeFarm.getPemKey());
                //BLog.e("E1","twwwooo");
				out = crypt.encryptStream(new FileOutputStream(path+ File.separator+filename));
                //BLog.e("E1","three");
				writer = new BufferedWriter(new OutputStreamWriter(out));
                //BLog.e("E1",writeContent);
				writer.write(Encrypt.encodeForEncription(writeContent));

                writer.flush();
                //BLog.e("E1","five");
                out.flush();
				out.close();

				completed=true;
			}
			catch(Exception e) {
                //BLog.e("ERRRRR","FWRITE: "+path+File.separator+filename+" -- "+e.getMessage());
	        	if(writer!=null) {
	        		try {
	        			writer.close();
	        		} catch(Exception ex) {}
	        	}
	        	if(out!=null) {
	        		try {
	        			out.close();
	        		} catch(Exception ex) {}
	        	}
			}
			this.status=STATUS_WRITE_OK;
	        return completed;
		} else {
			//BLog.e("E1","Ensure file path failed");
			return false;
		}
	}

