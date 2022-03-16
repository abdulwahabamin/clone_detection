	public boolean WriteToSd() {
		if(EnsurePathAndFile()) {
			boolean completed=false;
			BufferedWriter out =null;
			FileWriter writer=null;
	        try {
	        	writer=new FileWriter(path+ File.separator+filename);
	            out = new BufferedWriter(new FileWriter(path+ File.separator+filename));
	            out.write(Encrypt.encodeForEncription(writeContent));
	            out.close();
	            writer.close();
	            completed=true;
	        } catch (IOException e) {
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
			return false;
		}
	}

