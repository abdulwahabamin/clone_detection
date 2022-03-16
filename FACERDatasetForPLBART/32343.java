    public List<Cell> getCells(Context context, TelephonyManager mTelephonyManager) {
        List<Cell> cells = new ArrayList<>();

        String operator = mTelephonyManager.getNetworkOperator();
        int mnc;
        int mcc;

        // getNetworkOperator() may return empty string, probably due to dropped connection
        if (operator != null && operator.length() > 3) {
            mcc = Integer.valueOf(operator.substring(0, 3));
            mnc = Integer.valueOf(operator.substring(3));
        } else {
            appendLog(context, TAG, "Error retrieving network operator, skipping cell");
            mcc = 0;
            mnc = 0;
        }

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }

        CellLocation cellLocation = null;
        try {
            cellLocation = mTelephonyManager.getCellLocation();
        } catch (SecurityException securityException) {
            appendLog(context, TAG, "SecurityException when getCellLocation is called ", securityException);
        }

        appendLog(context, TAG, "getCells():cellLocation:", cellLocation);

        if (cellLocation != null) {
            if (cellLocation instanceof GsmCellLocation) {
                Cell cell = new Cell();
                cell.cellId = ((GsmCellLocation) cellLocation).getCid();
                cell.area = ((GsmCellLocation) cellLocation).getLac();
                cell.psc = ((GsmCellLocation) cellLocation).getPsc();
                cell.mcc = mcc;
                cell.mnc = mnc;
                cell.technology = mTelephonyManager.getNetworkType();
                appendLog(context, TAG, "GsmCellLocation for cell:", cell);
                cells.add(cell);
            } else if (cellLocation instanceof CdmaCellLocation) {
                appendLog(context, TAG, "getCells():cellLocation - CdmaCellLocation: Using CDMA cells for NLP is not yet implemented");
            } else {
                appendLog(context, TAG, "getCells():cellLocation - Got a CellLocation of an unknown class");
            }
        } else {
            appendLog(context, TAG, "getCellLocation returned null");
        }

        List<NeighboringCellInfo> neighboringCells = null;
        try {
            neighboringCells = mTelephonyManager.getNeighboringCellInfo();
        } catch (SecurityException securityException) {
            appendLog(context, TAG, "SecurityException when getCellLocation is called ", securityException);
        }
        appendLog(context, TAG, "getCells():neighboringCells:", neighboringCells);
        if (neighboringCells != null) {
            appendLog(context, TAG, "getCells():neighboringCells.size:", neighboringCells.size());
        } else {
            appendLog(context, TAG, "getNeighboringCellInfo returned null");
        }

        if (neighboringCells != null) {
            for (NeighboringCellInfo c : neighboringCells) {
                Cell cell = new Cell();
                cell.cellId = c.getCid();
                cell.area = c.getLac();
                cell.mcc = mcc;
                cell.mnc = mnc;
                cell.psc = c.getPsc();
                cell.signal = c.getRssi();
                cell.technology = c.getNetworkType();
                appendLog(context, TAG, "GsmCellLocation for cell:", cell);
                cells.add(cell);
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            List<CellInfo> cellsRawList = null;
            try {
                cellsRawList = mTelephonyManager.getAllCellInfo();
            } catch (SecurityException securityException) {
                appendLog(context, TAG, "SecurityException when getCellLocation is called ", securityException);
            }
            appendLog(context, TAG, "getCells():getAllCellInfo:cellsRawList:", cellsRawList);
            if (cellsRawList != null) {
                appendLog(context, TAG, "getAllCellInfo found cells: ", cellsRawList);
            } else {
                appendLog(context, TAG, "getAllCellInfo returned null");
            }

            if ((cellsRawList != null) && !cellsRawList.isEmpty()) {
                processCellInfoList(context, mTelephonyManager, cellsRawList, cells);
            }
        } else {
            appendLog(context, TAG, "getAllCellInfo is not available (requires API 17)");
        }

        appendLog(context, TAG, "getCells():return cells.size: ", cells);
        return cells;
    }

