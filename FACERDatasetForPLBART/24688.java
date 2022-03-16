		@Override
		public void run() {
			long offset = System.currentTimeMillis() - begin;  //the time offset for playing music
			if (currentTimeMill == 0) {
				nextTimeMill = (Long) times.poll();
				message = (String) messages.poll();

			}
			if (offset >= nextTimeMill) {
				Intent intent = new Intent();
				intent.putExtra("lrcMessage", message);
				intent.setAction(AppConstant.LRC_MESSAGE_ACTION);
				sendBroadcast(intent);

				nextTimeMill = (Long) times.poll();
				message = (String) messages.poll();
			}

			currentTimeMill = currentTimeMill + 10;

			handler.postDelayed(updateTimeCallBack, 10); //every 10 ms, put the call back task into queue
		}

