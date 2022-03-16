	/**
	 *
	 */
	private void resetShuffle(){
		synchronized(shuffleFrontList){
			shuffleFrontList.clear();
			shuffleBackList.clear();
			for(int i = 0;i < songAbsoluteFileNames.length;i++){
				shuffleFrontList.add(i);
			}
		}
	}

