package com.samples;

import java.util.List;

public class FraudulentActivityNotificator {

    public static int notifications(List<Integer> expenditure, int d) {
        int[] exp = expenditure.stream().mapToInt(i->i).toArray();
        int notificationCount = 0;

        // Counting Sort:
        // 0 <= expenditure[i] <= 200
        int[] data = new int[201];
        for (int i = 0; i < d; i++) {
            data[exp[i]]++;
        }

        for (int i = d; i < exp.length; i++) {

            double median = getMedian(d, data);

            if (exp[i] >= 2 * median) {
                notificationCount++;

            }

            data[exp[i]]++;
            data[exp[i - d]]--;

        }

        return notificationCount;

    }

    private static double getMedian(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == null && count >= d/2) {
                    m1 = j;
                }
                if (m2 == null && count >= d/2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

}
