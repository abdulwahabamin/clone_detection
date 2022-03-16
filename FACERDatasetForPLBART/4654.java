    public void reOrderFiles(Context context) {

        List<FileItem> sfiles=new ArrayList<FileItem>();
        List<FileItem> sfolders=new ArrayList<FileItem>();

        for(FileItem fi: fileList) {
            if(fi.isDirectory())
                sfolders.add(fi);
            else
                sfiles.add(fi);
        }

        currentFileCount=sfiles.size();
        currentFolderCount=sfolders.size();


        switch(ORDER_BY) {
            case ORDER_ORIGINAL:
                break;
            case ORDER_ALPHA_ASC:
                //BLog.e("ORDER alpha asc");
                Collections.sort(sfiles, PersonComparator.ascending(PersonComparator.getComparator(PersonComparator.NAME_SORT, PersonComparator.DATE_SORT)));
                Collections.sort(sfolders, PersonComparator.ascending(PersonComparator.getComparator(PersonComparator.NAME_SORT, PersonComparator.DATE_SORT)));
                break;
            case ORDER_ALPHA_DESC:
                //BLog.e("ORDER alpha desc");
                Collections.sort(sfiles, PersonComparator.decending(PersonComparator.getComparator(PersonComparator.NAME_SORT, PersonComparator.DATE_SORT)));
                Collections.sort(sfolders, PersonComparator.decending(PersonComparator.getComparator(PersonComparator.NAME_SORT, PersonComparator.DATE_SORT)));
                break;
            case ORDER_DATE_ASC:
                try {
                    Collections.sort(sfiles, PersonComparator.ascending(PersonComparator.getComparator(PersonComparator.DATE_SORT)));
                    Collections.sort(sfolders, PersonComparator.ascending(PersonComparator.getComparator(PersonComparator.NAME_SORT)));
                } catch(Exception e) {
                    Toast.makeText(context, context.getString(R.string.file_explore_order_error), Toast.LENGTH_SHORT);
                }
                break;
            case ORDER_DATE_DESC:
                //BLog.e("ORDER date desc");
                try {
                    Collections.sort(sfiles, PersonComparator.decending(PersonComparator.getComparator(PersonComparator.DATE_SORT)));
                    Collections.sort(sfolders, PersonComparator.ascending(PersonComparator.getComparator(PersonComparator.NAME_SORT)));

                } catch(Exception e) {
                    Toast.makeText(context, context.getString(R.string.file_explore_order_error), Toast.LENGTH_SHORT);
                }
                break;
        }
        sfolders.addAll(sfiles);

        fileList= sfolders;
        //Collections.sort(fileList, PersonComparator.decending(PersonComparator.getComparator(PersonComparator.NAME_SORT, PersonComparator.DATE_SORT)));
    }

