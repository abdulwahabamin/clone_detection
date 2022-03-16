		public BackgroundWork(ArrayList<ApplicationInfo> data)  {
			mDataSource = data;
			mData =  new byte[BUFFER];
						
			/*create dir if needed*/
			File d = new File("/sdcard/CMobile_temp/");
			if(!d.exists()) {
				d.mkdir();
				
				//then create this directory
				mDir.mkdir();
				
			} else {
				if(!mDir.exists())
					mDir.mkdir();
			}
		}

