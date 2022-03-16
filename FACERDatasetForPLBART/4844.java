	public synchronized boolean ReadSecureFromSd() {
		if(EnsurePathAndFile()) {
			StringBuffer contents = new StringBuffer();
			
			BufferedReader input = null;
			InputStream in=null;
			//String read=null;
            String readStr=null;
            //BLog.e("Er1",path+File.separator+filename);
			try {
				Encrypt enc = new Encrypt(useKey!=null?useKey:HomeFarm.getPemKey());
				in = enc.decryptStream(new FileInputStream(path+ File.separator+filename));

                byte[] bytes = new byte[1000];

                StringBuilder x = new StringBuilder();

                int numRead = 0;
                while ((numRead = in.read(bytes)) >= 0) {
                    x.append(new String(bytes, 0, numRead));
                }

                readStr=Encrypt.decodeFromEncription(x.toString());
                in.close();
                in=null;

			} catch(Exception e) {
				//BLog.e("FILES5",e.getClass()+" - "+e.getMessage()+" - "+path+File.separator+filename);
			} finally {
				try {
					if (in!= null) {
				      //flush and close both "input" and its underlying FileReader
						in.close();
				    }
				}
				catch (IOException ex) {
					//ex.printStackTrace();
				}
			}

			this.fileContent= readStr!=null?readStr:"";
			this.status=STATUS_READ_OK;
			return true;
		} else {
			return false;
		}
	}

