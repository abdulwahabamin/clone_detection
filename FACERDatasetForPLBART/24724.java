    public int getRelativeLeft(View view){
//        if (view.getParent()==view.getRootView())
//            return view.getLeft();
//        else
//            return view.getLeft()+getRelativeLeft((View) view.getParent());
        view.getLocationOnScreen(location);
        return location[0];
    }

