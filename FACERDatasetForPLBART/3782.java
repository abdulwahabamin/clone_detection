    @Override
    public String toString() {
        String returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (mValues != null) {
            for (int i = 0; i < mValues.length; ++i) {
                returnVal += "\n    " + mValues[i].toString();
            }
        }
        return returnVal;
    }

