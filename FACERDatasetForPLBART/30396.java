    /**
     * èŽ·å?–MAC wifi
     */
    @SuppressLint("HardwareIds")
    public static String getWiFiMAC(Context context) {
        String wifiMAC = null;

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                try {
                    // èŽ·å¾—IpDåœ°å?€
                    InetAddress ip = getLocalInetAddress();
                    byte[] b = NetworkInterface.getByInetAddress(ip).getHardwareAddress();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < b.length; i++) {
                        if (i != 0) {
                            sb.append(':');
                        }
                        String str = Integer.toHexString(b[i] & 0xFF);
                        sb.append(str.length() == 1 ? 0 + str : str);
                    }
                    wifiMAC = sb.toString().toUpperCase();
                } catch (Exception ignored) {
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
                for (NetworkInterface nif : all) {
                    if (!nif.getName().equalsIgnoreCase("wlan0")) {
                        continue;
                    }
                    byte[] macBytes = nif.getHardwareAddress();
                    if (macBytes != null) {
                        StringBuilder res1 = new StringBuilder();
                        for (byte b : macBytes) {
                            res1.append(String.format("%02X:", b));
                        }
                        if (res1.length() > 0) {
                            res1.deleteCharAt(res1.length() - 1);
                        }
                        wifiMAC = res1.toString();
                    }
                }
            } else {
                WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                if (wm != null) {
                    if (wm.getConnectionInfo() != null) {
                        wifiMAC = wm.getConnectionInfo().getMacAddress();
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return object2String(wifiMAC, Build.UNKNOWN).replace(":", "");
    }

