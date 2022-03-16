    /**
     * 1.优先CPU�?列�?�
     * 2.检验版本：<=6.0 请求IMEI 为null->获�?�DevID
     * 3.>=6.0 有�?��?：请求IMEI 为null -> 获�?�DevId
     * 4.>=6.0 无�?��?：->DevId
     */
    public static String getCPUSerial(Context context) {
        String defaultCPUSerial = "0000000000000000";
        String str, strCPU, cpuAddress = defaultCPUSerial;
        try {
            if (imeiFirst) {
                cpuAddress = getDeviceId(context);
            }
            if (!imeiFirst || Build.UNKNOWN.equals(cpuAddress)) {
                //读�?�CPU信�?�
                Process pp = Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial");
                InputStreamReader ir = new InputStreamReader(pp.getInputStream());
                LineNumberReader input = new LineNumberReader(ir);
                //查找CPU�?列�?�
                for (int i = 1; i < 100; i++) {
                    str = input.readLine();
                    if (str != null) {
                        //查找到�?列�?�所在行
                        if (str.contains("Serial")) {
                            //�??�?��?列�?�
                            strCPU = str.substring(str.indexOf(":") + 1, str.length());
                            //去空格
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
                        //没有IMEI
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

