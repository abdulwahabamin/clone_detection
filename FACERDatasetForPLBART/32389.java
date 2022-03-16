    private static String createRequest(List<Cell> cells, List<ScanResult> wiFis) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        JSONArray cellTowers = new JSONArray();

        if (cells != null) {
            String lastType = null;
            for (Cell cell : cells) {
                String networkType = getRadioType(cell);
                if (lastType != null && lastType.equals(networkType)) {
                    // We can't contribute if different cell types are mixed.
                    jsonObject.put("radioType", null);
                } else {
                    jsonObject.put("radioType", getRadioType(cell));
                }
                lastType = networkType;
                JSONObject cellTower = new JSONObject();
                cellTower.put("radioType", getRadioType(cell));
                cellTower.put("mobileCountryCode", cell.mcc);
                cellTower.put("mobileNetworkCode", cell.mnc);
                cellTower.put("locationAreaCode", cell.area);
                cellTower.put("cellId", cell.cellId);
                cellTower.put("signalStrength", cell.signal);
                if (cell.psc != -1)
                    cellTower.put("psc", cell.psc);
                cellTower.put("asu", calculateAsu(networkType, cell.signal));
                cellTowers.put(cellTower);
            }
        }
        JSONArray wifiAccessPoints = new JSONArray();
        if (wiFis != null) {
            for (ScanResult wiFi : wiFis) {
                JSONObject wifiAccessPoint = new JSONObject();
                wifiAccessPoint.put("macAddress", wiFi.BSSID);
                //wifiAccessPoint.put("age", age);
                if (wiFi.frequency != -1) wifiAccessPoint.put("channel", convertFrequencyToChannel(wiFi.frequency));
                if (wiFi.frequency != -1)
                    wifiAccessPoint.put("frequency", wiFi.frequency);
                wifiAccessPoint.put("signalStrength", wiFi.level);
                //wifiAccessPoint.put("signalToNoiseRatio", signalToNoiseRatio);
                wifiAccessPoints.put(wifiAccessPoint);
            }
        }
        jsonObject.put("cellTowers", cellTowers);
        jsonObject.put("wifiAccessPoints", wifiAccessPoints);
        jsonObject.put("fallbacks", new JSONObject().put("lacf", true).put("ipf", false));
        return jsonObject.toString();
    }

