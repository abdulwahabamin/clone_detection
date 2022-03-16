	public int loadDirectory() {
        int countImages=0;
        isImageDir=false;
        //BLog.e("........................."+currentPath);
        File dir = new File(currentPath);

		if(dir.isDirectory() && dir.canRead()) {
			rawList = Arrays.asList(dir.list());
			//int len=rawList.size();
			//BLog.e(".........................2");
			if(!rawList.isEmpty()) {
				int count = 0;
				for (String str : rawList) {
					//BLog.e(str);
					if (Files.isImage(Files.removeBriefFileExtension(str)))
						countImages++;
					if (++count > 10)
						break;
				}

				//int max = 10 > count ? 10 : count;
				//BLog.e("---max: " + count + ", count img: " + countImages+" ----- "+(((double)countImages / count)>0.5D));
				if (countImages!=0 && ((double)countImages / count) > 0.5D)
					isImageDir = true;//}
			}
			Collections.reverse(rawList);
			return rawList.size();
		} else {

			return -1;
		}
	}

