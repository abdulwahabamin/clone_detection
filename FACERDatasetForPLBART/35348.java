    @Override
    public void showPopupWindow() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.item_popupwindow, null);
        LinearLayout del = (LinearLayout) contentView.findViewById(R.id.del);
        ListView listView = (ListView) contentView.findViewById(R.id.popup_listview);
        PopupWindowAdapter adapter = new PopupWindowAdapter(hoursWeathers, getActivity());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        final PopupWindow popupWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.color.transparent));
        popupWindow.showAtLocation(rootLayout,Gravity.CENTER ,0, 0);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();

            }
        });
    }

