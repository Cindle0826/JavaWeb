package com.web.Service;

public class CalcAreaService {

    public double getAreaResult(int type, int r) {
        double area = 0;

        switch (type) {
            case 1:
                area = Math.pow(r, 2) * Math.PI;
                break;
            case 2:
                area = Math.pow(r, 3) * Math.PI * 4 / 3;
                break;
            default:
                area = -1;
        }
        return area;
    }
}
