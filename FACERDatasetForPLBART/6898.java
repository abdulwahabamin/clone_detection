    private String getPathString(){
        Stack<String> temp=new Stack<>();
        temp.addAll(nowPathStack);
        String result="";
        while (temp.size()!=0){
            result=temp.pop()+result;
        }
        return result;
    }

