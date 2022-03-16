    public static Map<String,List<FileDirectory>> listToMap(List<Map.Entry<String,
            List<FileDirectory>>> list){
        Map<String,List<FileDirectory>> resultMap=new HashMap<>();
        for (Map.Entry<String, List<FileDirectory>> ls : list) {
            String key=(String)ls.getKey();
            resultMap.put(ls.getKey(),ls.getValue());
        }
        return resultMap;
    }

