// ! wap in java to perform Assembly line scheduling

class AssemblyLineScheduling {
    static int carAssembly(int a[][], int t[][], int e[], int x[], int n) {
        int first = e[0] + a[0][0], second = e[1] + a[1][0];
        for (int i = 1; i < n; i++) {
            int up = Math.min(first + a[0][i], second + t[1][i] + a[0][i]);
            int down = Math.min(second + a[1][i], first + t[0][i] + a[1][i]);
            first = up;
            second = down;
        }
        return Math.min(first + x[0], second + x[1]);
    }

    public static void main(String[] args) {
        int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
        int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
        int e[] = { 10, 12 }, x[] = { 18, 7 };
        System.out.println("Minimum time required: " + carAssembly(a, t, e, x, a[0].length));
    }
}


// ? To perform enter the following command:
// ? javac AssemblyLineScheduling.java
// ? java AssemblyLineScheduling