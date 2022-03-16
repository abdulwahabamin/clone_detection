	private int grabNextShuffledPosition(){
		synchronized(shuffleFrontList){
			int threshold = (int) Math.ceil((songAbsoluteFileNames.length + 1) / 2);
			Log.d(TAG, "threshold: " + threshold);
			if(shuffleFrontList.size() < threshold){
				Log.d(TAG, "Shuffle queue is half empty, adding a new song...");
				shuffleFrontList.add(shuffleBackList.get(0));
				shuffleBackList.remove(0);
			}
			int rand = Math.abs(random.nextInt()) % shuffleFrontList.size();
			int loc = shuffleFrontList.get(rand);
			shuffleFrontList.remove(rand);
			shuffleBackList.add(loc);
			Log.i(TAG, "next position is: " + loc);
			String front = "";
			String back = "";
			for(int i : shuffleFrontList){
				front = front + "," + i;
			}
			for(int i : shuffleBackList){
				back = back + "," + i;
			}
			Log.i(TAG, "Front list = " + front);
			Log.i(TAG, "Back list = " + back);
			return loc;
		}
	}

