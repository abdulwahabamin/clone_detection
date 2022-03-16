     @Override	
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(mText);
         dest.writeString(mInfo);	
         dest.writeInt(mSelectable ? 1 : 0);
         dest.writeInt(mSelected ? 1 : 0);
         dest.writeInt(mCheckBoxVisible ? 1 : 0);
     }

