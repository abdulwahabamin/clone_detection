    public static Flowable<Map<String,List<FileDirectory>>> getRecentlyAddedFiles(final List<FileDirectory> recentList){
        List<FileDirectory> resultList=new ArrayList<>();
        return Flowable.create(new FlowableOnSubscribe<Map<String,List<FileDirectory>>>() {
            @Override
            public void subscribe(FlowableEmitter<Map<String,List<FileDirectory>>> e) throws Exception {
                Collections.sort(recentList, (l1, l2) -> {
                    try {
                        Date d1 = simpleDateFormat.parse(l1.getDate());
                        Date d2=simpleDateFormat.parse(l2.getDate());
                        return d2.compareTo(d1);
                    }catch (ParseException exp){
                        exp.printStackTrace();
                        return 1;
                    }
                });
                // Collections.sort(recentList,Collections.reverseOrder());
                List<FileDirectory> recentListTmp= Util.timeRemovedList(recentList);
                List<Map.Entry<String,List<FileDirectory>>> finalList=Stream
                        .of(recentListTmp)
                        .groupBy(FileDirectory::getDate)
                        .toList();
                list.clear();
                list=Util.getSortedFileList(finalList);
                Map<String,List<FileDirectory>> resultMap=Util.listToMap(finalList);
                e.onNext(resultMap);
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER);
    }

