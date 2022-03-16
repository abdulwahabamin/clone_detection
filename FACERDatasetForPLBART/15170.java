    public static int[] getEqualizerFrequencies(){
    	short numBands = mEqualizer.getNumberOfBands()<=6?mEqualizer.getNumberOfBands():6;	
    	int[] freqs= new int[numBands];
    	if(mEqualizer != null){
			for( int i = 0; i <= numBands-1 ; i++ ){
				int[] temp = mEqualizer.getBandFreqRange((short)i);
				freqs[i] = ((temp[1]-temp[0])/2)+temp[0];
			}
			return freqs;
    	}
    	return null;
    }

