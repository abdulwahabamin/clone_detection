    public static List<String> getSortedFileList(List<Map.Entry<String,
            List<FileDirectory>>> list){
        List<Date> dateList=new ArrayList<>();
        List<String> resultList=new ArrayList<>();
        try {
            //Date date = simpleDateFormat.parse("01/01/1980");
            for (Map.Entry<String, List<FileDirectory>> ls : list) {
                String key=(String)ls.getKey();
                dateList.add(simpleDateFormat.parse(key));
            }
            Collections.sort(dateList,Collections.reverseOrder());
            for(Date d:dateList){
                resultList.add(simpleDateFormat.format(d));
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return resultList;
    }

