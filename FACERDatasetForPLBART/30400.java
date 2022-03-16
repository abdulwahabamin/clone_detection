    /**
     * 根�?�设备硬件信�?�生�?15�?串�?�
     * <p>
     * Build.BRAND				--设备�?牌
     * • Build.CPU_ABI			--CPU指令集
     * • Build.DEVICE			    --设备�?�数
     * • Build.DISPLAY			--显示�?�?�数
     * • Build.HOST				--HOST
     * • Build.ID 				--修订版本列表
     * • Build.MANUFACTURER		--硬件制造商
     * • Build.MODEL				--版本
     * • Build.PRODUCT			--手机制造商
     * • Build.TAGS				--�??述build的标签
     * • Build.TYPE				--builder类型
     * • Build.USER
     */
    private static String getDevIDShort() {
        return "C" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
    }

