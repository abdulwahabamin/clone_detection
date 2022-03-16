	private void fileUtility(final String sourcePath,final FileInputStream source, final FileOutputStream destination,
										   FlowableEmitter<Integer> e) throws IOException{

		DataInputStream fileInputStream=new DataInputStream
				(source);
		DataOutputStream fileOutputStream=new DataOutputStream
				(destination);
		byte[] buffer=new byte[2048];
		int i;
		long size=new File(sourcePath).length();
		size/=1024;
		long total=0;

		while((i=fileInputStream.read(buffer))!=-1){
			total+=i/1024;
			if(e!=null)
				e.onNext((int)((total/(double)size)*100));
			fileOutputStream.write(buffer,0,i);
			//Log.e(TAG,"Writing data");
		}

		fileInputStream.close();
		fileOutputStream.close();

	}

