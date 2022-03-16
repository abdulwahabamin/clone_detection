    private byte[] getAlphabetDataBlock(int numElems){
        String string = "";

        for(int e = 0; e < numElems - 3; e++){
            string += String.valueOf((char)mLetterCounter);
            mLetterCounter = (mLetterCounter > 121 ? 97 : mLetterCounter + 1);
        }
        byte [] data = string.getBytes();
        byte [] finalData = new byte[data.length + 3];
        byte [] header = {0,0,0};


        System.arraycopy(data, 0, finalData, 0, data.length);
        System.arraycopy(header,0, finalData, finalData.length - 3, header.length );
        return finalData;
    }

