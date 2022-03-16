		@Override
		public void run() {
			//download URL: http://192.168.1.104:8082/mp3/a1.mp3
			//based on the name of mp3, it will generare the URL
			String urlStr=AppConstant.URL.BASE_URL+info.getMp3Name();
			
			//lrc URL
			String urlStr2=AppConstant.URL.BASE_URL+info.getLrcName();
			HttpDownloader downloader=new HttpDownloader();
			//download the file and save it into SDCard
			int result=downloader.downFile(urlStr, "mp3/", info.getMp3Name());
			downloader.downFile(urlStr2, "mp3/", info.getLrcName());
			String resultMsg=null;
			if(result==-1){
				resultMsg="download failed.";
			}else if(result==1){
				resultMsg="File exsited. Do not need to download again.";
			}else if(result==0){
				resultMsg="download successed";
			}
			//Using the notification to inform the result to users.
			
			//--------------------------------------------------------------------
		}

