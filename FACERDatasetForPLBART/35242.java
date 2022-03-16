    @Override
    public void addProvince() {
        final String[] provinces = {"北京", "天津", "河北", "山西", "山东", "辽�?", "�?�林", "黑龙江",
                "上海", "江�?", "浙江", "安徽", "�?建", "江西", "河�?�", "湖北", "湖�?�", "广东", "广西",
                "海�?�", "�?庆", "四�?", "贵州", "云�?�", "陕西", "甘肃", "�?�海", "内蒙�?�", "西�?", "�?�?",
                "新疆", "香港", "澳门", "�?�湾"};

        if (!isExistInProvince()) {
            for (int i = 0; i < provinces.length; i++) {
                ProvinceEntity entity = new ProvinceEntity(null, provinces[i]);
                addProvince(entity);
            }
        }

    }

