    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
            //for reason of better performance, save the fragment that is to be
            //destroyed, and reuse it in getItem() method since the fragment here
            //is reusable. In addition, remember to judge if the view to be returned
            //is null in method onCreateView() of MyObjectFragment, because every time
            //when getItem() method is called, the lifecycle of fragment returned by
            //getItem() will start over again in this case.
        if(fragmentQueue!=null){
            MyObjectFragment fg=(MyObjectFragment)object;
            fragmentQueue.add(fg);
        }
        super.destroyItem(container,position,object);
    }

