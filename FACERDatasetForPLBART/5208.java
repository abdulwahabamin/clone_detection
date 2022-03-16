    boolean isImageSet(ImageView imageView,int resId){
        Drawable.ConstantState current=imageView.getDrawable().getConstantState();
        Drawable.ConstantState toCheck;
        if(Build.VERSION.SDK_INT>=21)
            toCheck=context.getResources().getDrawable(resId,null).getConstantState();
        else
            toCheck=context.getResources().getDrawable(resId).getConstantState();

        if(current==toCheck)
            return false;
        return true;
    }

