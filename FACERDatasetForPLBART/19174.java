	private boolean checkTrialReactivationTime() {
		
		File file = new File(Environment.getExternalStorageDirectory() + "/.jams_info");
		if (file.exists()) {
			//The file exists. Try reading the reactivation time from it.
			String time = null;
			long reactivationTime = -1;
			try {
				time = FileUtils.readFileToString(file);
				reactivationTime = Long.parseLong(time);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				reactivationTime = -1;
			} catch (Exception e) {
				e.printStackTrace();
				reactivationTime = -1;
			}
			
			if (reactivationTime!=-1) {
				//Check if the current time is later than the reactivation time.
				long currentTime = System.currentTimeMillis();
				if (currentTime >= reactivationTime) {
					//Yeap, the trial's been reactivated.
					return true;
				} else {
					//Nope, the trial's still in the expired state.
					return false;
				}
				
			} else {
				//We were unable to read the activation time. Continue the trial.
				return true;
			}
			
		} else {
			//The file doesn't exist, so the trial is active.
			return true;
		}
		
	}

