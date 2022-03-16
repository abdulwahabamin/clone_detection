	public synchronized boolean ReadFromSd() {
		if(EnsurePathAndFile()) {
			StringBuilder contents = new StringBuilder();
			BufferedReader input = null;
			FileInputStream in=null;
			try {
				File file = new File(path+ File.separator+filename);
				in= new FileInputStream(file);
				input = new BufferedReader(new InputStreamReader(in));
				String line = null;
				while (( line = input.readLine()) != null){
                    if(contents.length()>0)
                        contents.append(System.getProperty("line.separator"));
					contents.append(line);

				}
                in.close();
				input.close();

			}
			catch (FileNotFoundException e) {
				BLog.e("FILES6", e.getMessage());
			}
			catch (IOException e){
				BLog.e("FILES7", e.getMessage());
			}
			this.fileContent= Encrypt.decodeFromEncription(contents.toString());
			this.status=STATUS_READ_OK;
			return true;
		} else {
			return false;
		}
	}

