    private void processCellInfoList(Context context,
                                     TelephonyManager mTelephonyManager,
                                     List<CellInfo> cellInfoList,
                                     List<Cell> cells) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return;
        }
        for (CellInfo c : cellInfoList) {
            Cell cell = new Cell();
            if (c instanceof CellInfoGsm) {
                //Log.v(TAG, "GSM cell found");
                cell.cellId = ((CellInfoGsm) c).getCellIdentity().getCid();
                cell.area = ((CellInfoGsm) c).getCellIdentity().getLac();
                cell.mcc = ((CellInfoGsm)c).getCellIdentity().getMcc();
                cell.mnc = ((CellInfoGsm)c).getCellIdentity().getMnc();
                cell.psc = ((CellInfoGsm)c).getCellIdentity().getPsc();
                cell.technology = mTelephonyManager.getNetworkType();
                appendLog(context, TAG, "CellInfoGsm for ", cell.mcc, cell.mnc, cell.area, cell.cellId, cell.technology);
            } else if (c instanceof CellInfoCdma) {
                /* object.put("cellId", ((CellInfoCdma)s).getCellIdentity().getBasestationId());
                    object.put("locationAreaCode", ((CellInfoCdma)s).getCellIdentity().getLac());
                    object.put("mobileCountryCode", ((CellInfoCdma)s).getCellIdentity().get());
                    object.put("mobileNetworkCode", ((CellInfoCdma)s).getCellIdentity().getMnc());*/
                appendLog(context, TAG, ":Using of CDMA cells for NLP not yet implemented");
            } else if (c instanceof CellInfoLte) {
                //Log.v(TAG, "LTE cell found");
                cell.cellId = ((CellInfoLte) c).getCellIdentity().getCi();
                cell.area = ((CellInfoLte) c).getCellIdentity().getTac();
                cell.mcc = ((CellInfoLte)c).getCellIdentity().getMcc();
                cell.mnc = ((CellInfoLte)c).getCellIdentity().getMnc();
                cell.technology = mTelephonyManager.getNetworkType();
                appendLog(context, TAG, "CellInfoLte for ", cell.mcc, cell.mnc, cell.area, cell.cellId, cell.technology, ((CellInfoLte)c).getCellIdentity().getPci());
            } else if (c instanceof CellInfoWcdma) {
                //Log.v(TAG, "CellInfoWcdma cell found");
                cell.cellId = ((CellInfoWcdma) c).getCellIdentity().getCid();
                cell.area = ((CellInfoWcdma) c).getCellIdentity().getLac();
                cell.mcc = ((CellInfoWcdma)c).getCellIdentity().getMcc();
                cell.mnc = ((CellInfoWcdma)c).getCellIdentity().getMnc();
                cell.psc = ((CellInfoWcdma)c).getCellIdentity().getPsc();
                cell.technology = mTelephonyManager.getNetworkType();
                appendLog(context, TAG, "CellInfoLte for ", cell.mcc, cell.mnc, cell.area, cell.cellId, cell.technology, ((CellInfoWcdma) c).getCellIdentity().getPsc());
            } else {
                appendLog(context, TAG, "CellInfo of unexpected type: " + c);
            }
            cells.add(cell);
        }
    }

