        public void setNewPattern(String s1, String s2, String e1, String e2) {
            mStartId1 = s1;
            mStartId2 = s2;
            mEndId1 = e1;
            mEndId2 = e2;
            mStartControlBytes = (mStartId1 + "0" + mStartId2).getBytes();
            mEndControlLength = mEndId1.length() + mEndId2.length() + 3; // leave 3 for exit code;
        }

