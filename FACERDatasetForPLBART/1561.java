    public void showLoading(View view){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        popupWindow = new PopupWindow(layoutInflater.inflate(R.layout.loading_background, null, false),
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,  true);

        if (popupWindow != null){
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        }
    }

