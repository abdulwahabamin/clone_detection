    public void clear(){
        if (resultCode != 0 || failureMessage != null) {
            resultCode = 0;
            failureMessage = "";
            other = "";
        }
    }

