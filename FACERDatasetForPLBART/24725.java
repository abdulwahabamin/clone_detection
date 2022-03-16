    public int getRelativeTop(View view){
        if (view.getParent()==view.getRootView())
            return view.getTop();
        else
            return view.getTop()+getRelativeTop((View) view.getParent());
//        view.getLocationOnScreen(location);
//        return location[1];
    }

