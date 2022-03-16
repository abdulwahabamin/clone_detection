	    /** Will cancel the listening socket, and cause the thread to finish */
	    public void cancel() {
	        try {
	            socket.close();
	        } catch (IOException e) { }
	    }

