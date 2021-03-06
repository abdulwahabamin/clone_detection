    public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(activity, v);
        try {
            Class<?> classPopupMenu = Class.forName(popupMenu
                    .getClass().getName());
            Field mPopup = classPopupMenu.getDeclaredField("mPopup");
            mPopup.setAccessible(true);
            Object menuPopupHelper = mPopup.get(popupMenu);
            Class<?> classPopupHelper = Class.forName(menuPopupHelper
                    .getClass().getName());
            Method setForceIcons = classPopupHelper.getMethod(
                    "setForceShowIcon", boolean.class);
            setForceIcons.invoke(menuPopupHelper, true);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        //MenuItem main = popupMenu.getMenu().add("");
        //popupMenu.set
        //popupMenu.getMenuInflater().inflate(R.menu.contacts_clipboard, popupMenu.getMenu());
        //FileItem fi = new File(file);


        MenuItem minfo = popupMenu.getMenu().add(wrapInSpan(fi.getName()));
        minfo.setIcon(activity.getResources().getDrawable(Files.getFileRIcon(fi.getAbsolutePath())));


        MenuItem dinfo = popupMenu.getMenu().add(wrapInSpan(Num.btyesToFileSizeString(fi.length())));
        dinfo.setIcon(activity.getResources().getDrawable(R.drawable.content_save));
        MenuItem calinfo = popupMenu.getMenu().add(wrapInSpan((new Cal(fi.lastModified())).friendlyReadDate()));
        calinfo.setIcon(activity.getResources().getDrawable(R.drawable.content_edit));
        if(Files.isImage(fi.getName())) {
            Bitmap b = BitmapFunctions.getBitmap(activity,fi);
            MenuItem imginfo = popupMenu.getMenu().add(wrapInSpan(activity.getString(R.string.label_images)+": "+b.getWidth() +"w X "+b.getHeight()+"h"));

        }

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                //ContactsSelectedClipboard.removePerson(pfocus);
                //ContactsSelectedClipboard.clearSearch();
                //csadapter=new ContactsSelectedAdapter(context);
                //contactsList.setAdapter(csadapter);
                //SearchFilter sf=searchListAdapter.getFilter();
                //sf=null;
                //manualType.setText("");
                //refreshData();
                //BLog.e("bpv", "2");
                //Bgo.tryRefreshCurrentFragment();

                return true;
            }
        });

        popupMenu.show();
    }

