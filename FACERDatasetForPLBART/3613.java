    @Override
    public String toString() {
        String returnVal = " ";
        for (int i = 0; i < mNumKeyframes; ++i) {
            returnVal += mKeyframes.get(i).getValue() + "  ";
        }
        return returnVal;
    }

