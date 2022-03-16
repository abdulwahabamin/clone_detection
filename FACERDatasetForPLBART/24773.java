    public static void setSongPlay(int lastPosition,int currentPosition){
        if(lastPosition>=0) {
            try{
                mRecyclerView.findViewHolderForLayoutPosition(lastPosition).itemView.findViewById(R.id.isplay).setVisibility(View.INVISIBLE);
            }
            catch (Exception e) {
            }
        }
        try{
            mRecyclerView.findViewHolderForLayoutPosition(currentPosition).itemView.findViewById(R.id.isplay).setVisibility(View.VISIBLE);
        }
        catch (Exception e){}
    }

