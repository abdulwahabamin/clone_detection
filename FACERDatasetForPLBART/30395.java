    /**
     * 1.ä¼˜å…ˆCPUåº?åˆ—å?·
     * 2.æ£€éªŒç‰ˆæœ¬ï¼š<=6.0 è¯·æ±‚IMEI ä¸ºnull->èŽ·å?–DevID
     * 3.>=6.0 æœ‰æ?ƒé™?ï¼šè¯·æ±‚IMEI ä¸ºnull -> èŽ·å?–DevId
     * 4.>=6.0 æ— æ?ƒé™?ï¼š->DevId
     */
    public static String getCPUSerial(Context context) {
        String defaultCPUSerial = "0000000000000000";
        String str, strCPU, cpuAddress = defaultCPUSerial;
        try {
            if (imeiFirst) {
                cpuAddress = getDeviceId(context);
            }
            if (!imeiFirst || Build.UNKNOWN.equals(cpuAddress)) {
                //è¯»å?–CPUä¿¡æ?¯
                Process pp = Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial");
                InputStreamReader ir = new InputStreamReader(pp.getInputStream());
                LineNumberReader input = new LineNumberReader(ir);
                //æŸ¥æ‰¾CPUåº?åˆ—å?·
                for (int i = 1; i < 100; i++) {
                    str = input.readLine();
                    if (str != null) {
                        //æŸ¥æ‰¾åˆ°åº?åˆ—å?·æ‰€åœ¨è¡Œ
                        if (str.contains("Serial")) {
                            //æ??å?–åº?åˆ—å?·
                            strCPU = str.substring(str.indexOf(":") + 1, str.length());
                            //åŽ»ç©ºæ ¼
                            cpuAddress = strCPU.trim();
                            break;
                        }
                    }
                }
            }

            if (defaultCPUSerial.equals(cpuAddress) || TextUtils.isEmpty(cpuAddress) || Build.UNKNOWN.equals(cpuAddress)) {
                if (imeiFirst) {
                    cpuAddress = getDevIDShort();
                } else {
                    cpuAddress = getDeviceId(context);
                    if (Build.UNKNOWN.equals(cpuAddress)) {
                        //æ²¡æœ‰IMEI
                        cpuAddress = getDevIDShort();
                    }
                }
            } else if (!imeiFirst) {
                cpuAddress = "A" + cpuAddress;
            }
        } catch (Exception ignored) {
        }
        return cpuAddress;
    }

