    private void processIncomingMsg(String msg){
        if(msg.startsWith("/")){
            String[] tokens = msg.split(" ", 2);
            if(tokens[0].compareTo("/name") == 0){
                showConnectedName(tokens[1]);
            }else if(tokens[0].compareTo("/send") == 0){
                transferData();
            }
        }else{
            showIncomingMessage(msg);
        }
    }

