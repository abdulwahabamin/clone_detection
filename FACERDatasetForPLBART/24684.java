	private void prepareLrc(String lrcName) {
		try {
			InputStream inputStream = new FileInputStream(getLrcPath(lrcName));
			LrcProcessor processor = new LrcProcessor();
			queues = processor.process(inputStream);
			updateTimeCallBack = new UpdateTimeCallBack(queues);  //create callback task
			begin = 0;
			nextTimeMill = 0;
			currentTimeMill = 0;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

