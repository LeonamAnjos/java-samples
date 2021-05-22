package com.samples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpecialString {

	static class Point {
	    public char key;
	    public long count;

	    public Point(char x, long y) {
	        key = x;
	        count = y;
	    }
	}

	public static long substrCount(int n, String s) {
		return substrCount(groupCharsKeepingSequence(n, s));
	}

	private static long substrCount(List<Point> l) {
		if (l.size() < 3) {
			return l.stream().map((p) -> p.count).reduce(0L, (a, b) -> a + sumOfRange(b));
		}

        Iterator<Point> itr = l.iterator();
        Point prev, curr, next;
        curr = itr.next();
        next = itr.next();
        long count = sumOfRange(curr.count);
        for(int i = 1; i < l.size() - 1; i++) {
            prev = curr;
            curr = next;
            next = itr.next();
            count += sumOfRange(curr.count);
            if(prev.key == next.key && curr.count == 1)
                count += prev.count > next.count ? next.count : prev.count;
        }

	    return count + sumOfRange(next.count);
	}

	private static long sumOfRange(long value) {
		return (value * (value + 1)) / 2;
	}

	private static List<Point> groupCharsKeepingSequence(int n, String s) {
		List<Point> l = new ArrayList<Point>();

		s = s + " ";
	    long count = 0;
	    char ch = s.charAt(0);
	    for(int i = 1; i <= n ; i++) {
        	count++;

	    	if(ch != s.charAt(i)) {
	            l.add(new Point(ch, count));
	            count = 0;
	            ch = s.charAt(i);
	        }
	    }
		return l;
	}
}
