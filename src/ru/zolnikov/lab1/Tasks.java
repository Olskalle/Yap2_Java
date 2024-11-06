package ru.zolnikov.lab1;

public class Tasks {
    //1.1
    public double fraction(double x) {
        return x % 1;
    }

    // 1.3
    public int charToNum(char c) {
        if (c <'0' || c > '9')
            return -1;

        return (int)c - 48;
    }

    // 1.5
    public boolean is2Digit(int x) {
        var abs = Math.abs(x);
        return (abs > 9 && abs < 100);
    }

    // 1.7
    public boolean isInRange(int a, int b, int num) {
        
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        
        return num >= a && num <= b;
    }

    // 1.9
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    // 2.1
    public int abs(int x) {
        return x < 0 
            ? -x 
            : x;
    }

    // 2.3
    public boolean is35(int x) {
        return (x % 3 == 0 || x % 5 == 0) && (x % 15 != 0);
    }

    // 2.5
    public int max3(int x, int y, int z) {
        var max = (x > y) ? x : y;
        
        return max > z ? max : z;
    }

    // 2.7
    public int sum2(int x, int y) {
        var sum = x + y;

        return sum >= 10 && sum <= 19
            ? 20
            : sum;
    }

    // 2.9
    public String day (int x) {
        switch (x) {
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
            case 7: return "воскресенье";
            default: return "это не день недели";
        }
    }

    // 3.1
    public String listNums(int x) {
        if (x < 0)
            return "";

        var str = "0";
        
        if (x == 0)
            return str;

        for (var i = 1; i <= x; i++) {
            str += " " + i;
        }

        return str;
    }

    // 3.3
    public String chet(int x) {
        if (x < 0)
            return "";

        var str = "0";
        
        if (x == 0)
            return str;
        
        x = (x / 2) * 2;
        for (var i = 2; i <= x; i += 2) {
            str += " " + i;
        }

        return str;
    }

    // 3.5
    public int numLen(long x) {
        if (x < 0)
            x *= -1;

        var len = 0;
        while(x > 0) {
            len++;
            x /= 10;
        }

        return len;
    }

    // 3.7
    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // 3.9
    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        } 
    }

    // 4.1
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // 4.3
    public int maxAbs(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // 4.5
    public int[] add(int[] arr, int[] ins, int pos) {
        if (pos > arr.length)
            pos = arr.length;
        
        int[] result = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }
        return result;
    }
    
    // 4.7
    public int[] reverseBack(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // 4.9
    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
    
        int[] entries = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                entries[index++] = i;
            }
        }
        
        return entries;
    }
}