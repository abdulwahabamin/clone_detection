    /**
     * èŽ·å?–ç³»ç»Ÿçš„å…¶ä»–ä¿¡æ?¯ï¼Œç»„æˆ?json
     */
    public static String getOther(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        try {
            sb.append("\"kvn\":\"").append(BuildConfig.VERSION_NAME).append("\"").append(",");
            sb.append("\"kvc\":\"").append(BuildConfig.VERSION_CODE).append("\"").append(",");
            sb.append("\"sid\":\"").append(object2String(Build.ID)).append("\"").append(",");
            sb.append("\"sdv\":\"").append(object2String(Build.DEVICE)).append("\"").append(",");
            sb.append("\"sbr\":\"").append(object2String(Build.BRAND)).append("\"").append(",");
            sb.append("\"smo\":\"").append(object2String(Build.MODEL)).append("\"").append(",");
            sb.append("\"spd\":\"").append(object2String(Build.PRODUCT)).append("\"").append(",");
            sb.append("\"smf\":\"").append(object2String(Build.MANUFACTURER)).append("\"").append(",");
            sb.append("\"shw\":\"").append(object2String(Build.HARDWARE)).append("\"").append(",");
            sb.append("\"sfp\":\"").append(object2String(Build.FINGERPRINT)).append("\"").append(",");
            sb.append("\"stp\":\"").append(object2String(Build.TYPE)).append("\"").append(",");
            sb.append("\"shs\":\"").append(object2String(Build.HOST)).append("\"").append(",");
            sb.append("\"sbd\":\"").append(object2String(Build.BOARD)).append("\"").append(",");
            sb.append("\"stm\":\"").append(object2String(Build.TIME)).append("\"").append(",");
            sb.append("\"sca\":\"").append(object2String(Build.CPU_ABI)).append("\"").append(",");
            sb.append("\"sbl\":\"").append(object2String(Build.BOOTLOADER)).append("\"").append(",");
            sb.append("\"sdp\":\"").append(object2String(Build.DISPLAY)).append("\"").append(",");
            sb.append("\"stg\":\"").append(object2String(Build.TAGS)).append("\"").append(",");
            sb.append("\"svr\":\"").append(object2String(Build.VERSION.RELEASE)).append("\"").append(",");
            sb.append("\"svs\":\"").append(object2String(Build.VERSION.SDK_INT)).append("\"").append(",");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                sb.append("\"svb\":\"").append(object2String(Build.VERSION.BASE_OS)).append("\"").append(",");
            }
            sb.append("\"svc\":\"").append(object2String(Build.VERSION.CODENAME)).append("\"").append(",");
            sb.append("\"svi\":\"").append(object2String(Build.VERSION.INCREMENTAL)).append("\"").append(",");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                sb.append("\"svs\":\"").append(object2String(Build.VERSION.SECURITY_PATCH)).append("\"").append(",");
            }

            if (context != null) {
                TelephonyManager phone = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

                sb.append("\"avc\":\"").append(context.getPackageName()).append("\"").append(",");
                sb.append("\"avn\":\"").append(getVersionName(context)).append("\"").append(",");
                sb.append("\"aan\":\"").append(getAppName(context)).append("\"").append(",");
                if (phone != null) {
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                        @SuppressLint("HardwareIds") String telephone = phone.getSimSerialNumber();
                        if (!TextUtils.isEmpty(telephone)) {
                            sb.append("\"psn\":\"").append(object2String(telephone)).append("\"").append(",");
                        }
                        @SuppressLint("HardwareIds") String subscriberId = phone.getSubscriberId();
                        if (!TextUtils.isEmpty(subscriberId)) {
                            sb.append("\"psi\":\"").append(object2String(subscriberId)).append("\"").append(",");
                        }
                    }
                    int phoneType = phone.getPhoneType();
                    sb.append("\"ppt\":\"").append(object2String(phoneType)).append("\"").append(",");
                    String simCountryIso = phone.getSimCountryIso();
                    if (!TextUtils.isEmpty(simCountryIso)) {
                        sb.append("\"psc\":\"").append(object2String(simCountryIso)).append("\"").append(",");
                    }
                    String simOperator = phone.getSimOperator();
                    if (!TextUtils.isEmpty(simOperator)) {
                        sb.append("\"pso\":\"").append(object2String(simOperator)).append("\"").append(",");
                    }
                    String simOperatorName = phone.getSimOperatorName();
                    if (!TextUtils.isEmpty(simOperatorName)) {
                        sb.append("\"psn\":\"").append(object2String(simOperatorName)).append("\"").append(",");
                    }
                }

                if (context.getResources() != null) {
                    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
                    if (metrics != null) {
                        sb.append("\"dmd\":\"").append(object2String(metrics.density)).append("\"").append(",");
                        sb.append("\"ddp\":\"").append(object2String(metrics.densityDpi)).append("\"").append(",");
                        sb.append("\"dmx\":\"").append(object2String(metrics.xdpi)).append("\"").append(",");
                        sb.append("\"dmy\":\"").append(object2String(metrics.ydpi)).append("\"").append(",");
                        sb.append("\"dsd\":\"").append(object2String(metrics.scaledDensity)).append("\"").append(",");
                    }
                }
            }

            sb = sb.deleteCharAt(sb.length() - 1);
        } catch (Exception ignored) {
        }
        sb.append("}");
        return sb.toString();
    }

