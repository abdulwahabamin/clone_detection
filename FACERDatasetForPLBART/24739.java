    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child=rv.findChildViewUnder(e.getX(),e.getY());
        if(child!=null && clickListener!=null && mGestureDetector.onTouchEvent(e))
        {
            clickListener.onClick(child,rv.getChildAdapterPosition(child));
        }
        return false;
    }

