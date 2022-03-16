     public IconifiedText(Parcel in){
       mText = in.readString();
       mInfo = in.readString();
       mSelectable = in.readInt() == 1 ? true : false;	
       mSelected = in.readInt() == 1 ? true : false;
       mCheckBoxVisible = in.readInt() == 1 ? true : false;
     }

