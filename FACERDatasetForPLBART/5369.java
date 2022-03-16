    public static List<FileDirectory> sortBy(List<FileDirectory> list,int selection) {
        switch (selection) {

            case NAME:
                Collections.sort(list, (FileDirectory f1, FileDirectory f2) -> {
                    return f1.getName().compareTo(f2.getName());
                    }
                );
                break;

            case SIZE:
                Collections.sort(list, (FileDirectory f1, FileDirectory f2) -> {
                            return f1.getSize().compareTo(f2.getSize());
                        }
                );
                break;

            case DATE:

                Collections.sort(list, new Comparator<FileDirectory>() {
                            @Override
                            public int compare(FileDirectory f1, FileDirectory f2) {
                                Date d1=null,d2=null;
                                try {

                                    d1 = simpleDateFormat.parse(f1.getDate());
                                    d2= simpleDateFormat.parse(f2.getDate());
                                    Log.e(TAG,"d1: "+d1+" d2: "+d2);
                                    return d1.compareTo(d2);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                return 0;
                            }
                        }
                );
                break;


        }
        return list;
    }

