package org.lidochka.branchandbound;

//auto-generated and just formatted
class BABMethod_5 implements BABMethod {

    static {
        BABGate.methods[5] = new BABMethod_5();
    }

    public boolean hasOneAuthomorphism(final int[][] matrix) {
        BoolStore store = new BoolStore();
        runFixed0(matrix, store, 0, 1, 2, 3, 4);
        return store.state;
    }

    private void runFixed0(final int[][] matrix, final BoolStore store
            , final int x0, final int x1, final int x2, final int x3, final int x4) {
        if (store.state) return;
        runFixed1(matrix, store, x0, x1, x2, x3, x4);
        runFixed1(matrix, store, x1, x0, x2, x3, x4);
        runFixed1(matrix, store, x2, x0, x1, x3, x4);
        runFixed1(matrix, store, x3, x0, x1, x2, x4);
        runFixed1(matrix, store, x4, x0, x1, x2, x3);
    }

    private void runFixed1(final int[][] matrix, final BoolStore store
            , final int x0, final int x1, final int x2, final int x3, final int x4) {
        if (store.state) return;
        if (x0 == 0) return;
        if (matrix[0][0] != matrix[x0][x0]) return;
        runFixed2(matrix, store, x0, x1, x2, x3, x4);
        runFixed2(matrix, store, x0, x2, x1, x3, x4);
        runFixed2(matrix, store, x0, x3, x1, x2, x4);
        runFixed2(matrix, store, x0, x4, x1, x2, x3);
    }

    private void runFixed2(final int[][] matrix, final BoolStore store
            , final int x0, final int x1, final int x2, final int x3, final int x4) {
        if (store.state) return;
        if (x1 == 1) return;
        if (matrix[0][1] != matrix[x0][x1]) return;
        if (matrix[1][1] != matrix[x1][x1]) return;
        runFixed3(matrix, store, x0, x1, x2, x3, x4);
        runFixed3(matrix, store, x0, x1, x3, x2, x4);
        runFixed3(matrix, store, x0, x1, x4, x2, x3);
    }

    private void runFixed3(final int[][] matrix, final BoolStore store
            , final int x0, final int x1, final int x2, final int x3, final int x4) {
        if (store.state) return;
        if (x2 == 2) return;
        if (matrix[0][2] != matrix[x0][x2]) return;
        if (matrix[1][2] != matrix[x1][x2]) return;
        if (matrix[2][2] != matrix[x2][x2]) return;
        runFixed4(matrix, store, x0, x1, x2, x3, x4);
        runFixed4(matrix, store, x0, x1, x2, x4, x3);
    }

    private void runFixed4(final int[][] matrix, final BoolStore store
            , final int x0, final int x1, final int x2, final int x3, final int x4) {
        if (store.state) return;
        if (x3 == 3) return;
        if (matrix[0][3] != matrix[x0][x3]) return;
        if (matrix[1][3] != matrix[x1][x3]) return;
        if (matrix[2][3] != matrix[x2][x3]) return;
        if (matrix[3][3] != matrix[x3][x3]) return;
        runFixed5(matrix, store, x0, x1, x2, x3, x4);
    }

    private void runFixed5(final int[][] matrix, final BoolStore store
            , final int x0, final int x1, final int x2, final int x3, final int x4) {
        if (store.state) return;
        if (x4 == 4) return;
        if (matrix[0][4] != matrix[x0][x4]) return;
        if (matrix[1][4] != matrix[x1][x4]) return;
        if (matrix[2][4] != matrix[x2][x4]) return;
        if (matrix[3][4] != matrix[x3][x4]) return;
        if (matrix[4][4] != matrix[x4][x4]) return;
        store.state = true;
    }

}
