	public static String getInternalIP () {
		String address=null;
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().toString().contains(".")) {
                    	address= inetAddress.getHostAddress().toString();
                    	//BLog.e("INET", address);
                    }
                }
            }
        } catch (SocketException ex) {
            //Log.i("externalip", ex.toString());
        }
        return address;
	}

