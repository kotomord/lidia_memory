package org.lidochka.branchandbound;
//auto-generated and just formatted
class BABMethod_9 implements BABMethod{

static{
 BABGate.methods[9] = new BABMethod_9();
}

public boolean hasOneAuthomorphism(final int[][] matrix){
BoolStore store = new BoolStore();
runFixed0(matrix, store, 0, 1, 2, 3, 4, 5, 6, 7, 8);
 return store.state;
}

private void runFixed0(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
runFixed1(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed1(matrix, store, x1, x0, x2, x3, x4, x5, x6, x7, x8);
runFixed1(matrix, store, x2, x0, x1, x3, x4, x5, x6, x7, x8);
runFixed1(matrix, store, x3, x0, x1, x2, x4, x5, x6, x7, x8);
runFixed1(matrix, store, x4, x0, x1, x2, x3, x5, x6, x7, x8);
runFixed1(matrix, store, x5, x0, x1, x2, x3, x4, x6, x7, x8);
runFixed1(matrix, store, x6, x0, x1, x2, x3, x4, x5, x7, x8);
runFixed1(matrix, store, x7, x0, x1, x2, x3, x4, x5, x6, x8);
runFixed1(matrix, store, x8, x0, x1, x2, x3, x4, x5, x6, x7);
}

private void runFixed1(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x0 == 0) return;
if(matrix[0][0] != matrix[x0][x0]) return;
runFixed2(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed2(matrix, store, x0, x2, x1, x3, x4, x5, x6, x7, x8);
runFixed2(matrix, store, x0, x3, x1, x2, x4, x5, x6, x7, x8);
runFixed2(matrix, store, x0, x4, x1, x2, x3, x5, x6, x7, x8);
runFixed2(matrix, store, x0, x5, x1, x2, x3, x4, x6, x7, x8);
runFixed2(matrix, store, x0, x6, x1, x2, x3, x4, x5, x7, x8);
runFixed2(matrix, store, x0, x7, x1, x2, x3, x4, x5, x6, x8);
runFixed2(matrix, store, x0, x8, x1, x2, x3, x4, x5, x6, x7);
}

private void runFixed2(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x1 == 1) return;
if(matrix[0][1] != matrix[x0][x1]) return;
if(matrix[1][1] != matrix[x1][x1]) return;
runFixed3(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed3(matrix, store, x0, x1, x3, x2, x4, x5, x6, x7, x8);
runFixed3(matrix, store, x0, x1, x4, x2, x3, x5, x6, x7, x8);
runFixed3(matrix, store, x0, x1, x5, x2, x3, x4, x6, x7, x8);
runFixed3(matrix, store, x0, x1, x6, x2, x3, x4, x5, x7, x8);
runFixed3(matrix, store, x0, x1, x7, x2, x3, x4, x5, x6, x8);
runFixed3(matrix, store, x0, x1, x8, x2, x3, x4, x5, x6, x7);
}

private void runFixed3(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x2 == 2) return;
if(matrix[0][2] != matrix[x0][x2]) return;
if(matrix[1][2] != matrix[x1][x2]) return;
if(matrix[2][2] != matrix[x2][x2]) return;
runFixed4(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed4(matrix, store, x0, x1, x2, x4, x3, x5, x6, x7, x8);
runFixed4(matrix, store, x0, x1, x2, x5, x3, x4, x6, x7, x8);
runFixed4(matrix, store, x0, x1, x2, x6, x3, x4, x5, x7, x8);
runFixed4(matrix, store, x0, x1, x2, x7, x3, x4, x5, x6, x8);
runFixed4(matrix, store, x0, x1, x2, x8, x3, x4, x5, x6, x7);
}

private void runFixed4(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x3 == 3) return;
if(matrix[0][3] != matrix[x0][x3]) return;
if(matrix[1][3] != matrix[x1][x3]) return;
if(matrix[2][3] != matrix[x2][x3]) return;
if(matrix[3][3] != matrix[x3][x3]) return;
runFixed5(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed5(matrix, store, x0, x1, x2, x3, x5, x4, x6, x7, x8);
runFixed5(matrix, store, x0, x1, x2, x3, x6, x4, x5, x7, x8);
runFixed5(matrix, store, x0, x1, x2, x3, x7, x4, x5, x6, x8);
runFixed5(matrix, store, x0, x1, x2, x3, x8, x4, x5, x6, x7);
}

private void runFixed5(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x4 == 4) return;
if(matrix[0][4] != matrix[x0][x4]) return;
if(matrix[1][4] != matrix[x1][x4]) return;
if(matrix[2][4] != matrix[x2][x4]) return;
if(matrix[3][4] != matrix[x3][x4]) return;
if(matrix[4][4] != matrix[x4][x4]) return;
runFixed6(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed6(matrix, store, x0, x1, x2, x3, x4, x6, x5, x7, x8);
runFixed6(matrix, store, x0, x1, x2, x3, x4, x7, x5, x6, x8);
runFixed6(matrix, store, x0, x1, x2, x3, x4, x8, x5, x6, x7);
}

private void runFixed6(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x5 == 5) return;
if(matrix[0][5] != matrix[x0][x5]) return;
if(matrix[1][5] != matrix[x1][x5]) return;
if(matrix[2][5] != matrix[x2][x5]) return;
if(matrix[3][5] != matrix[x3][x5]) return;
if(matrix[4][5] != matrix[x4][x5]) return;
if(matrix[5][5] != matrix[x5][x5]) return;
runFixed7(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed7(matrix, store, x0, x1, x2, x3, x4, x5, x7, x6, x8);
runFixed7(matrix, store, x0, x1, x2, x3, x4, x5, x8, x6, x7);
}

private void runFixed7(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x6 == 6) return;
if(matrix[0][6] != matrix[x0][x6]) return;
if(matrix[1][6] != matrix[x1][x6]) return;
if(matrix[2][6] != matrix[x2][x6]) return;
if(matrix[3][6] != matrix[x3][x6]) return;
if(matrix[4][6] != matrix[x4][x6]) return;
if(matrix[5][6] != matrix[x5][x6]) return;
if(matrix[6][6] != matrix[x6][x6]) return;
runFixed8(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
runFixed8(matrix, store, x0, x1, x2, x3, x4, x5, x6, x8, x7);
}

private void runFixed8(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x7 == 7) return;
if(matrix[0][7] != matrix[x0][x7]) return;
if(matrix[1][7] != matrix[x1][x7]) return;
if(matrix[2][7] != matrix[x2][x7]) return;
if(matrix[3][7] != matrix[x3][x7]) return;
if(matrix[4][7] != matrix[x4][x7]) return;
if(matrix[5][7] != matrix[x5][x7]) return;
if(matrix[6][7] != matrix[x6][x7]) return;
if(matrix[7][7] != matrix[x7][x7]) return;
runFixed9(matrix, store, x0, x1, x2, x3, x4, x5, x6, x7, x8);
}

private void runFixed9(final  int[][] matrix, final BoolStore store 
, final int x0, final int x1, final int x2, final int x3, final int x4, final int x5, final int x6, final int x7, final int x8){
if(store.state) return;
if (x8 == 8) return;
if(matrix[0][8] != matrix[x0][x8]) return;
if(matrix[1][8] != matrix[x1][x8]) return;
if(matrix[2][8] != matrix[x2][x8]) return;
if(matrix[3][8] != matrix[x3][x8]) return;
if(matrix[4][8] != matrix[x4][x8]) return;
if(matrix[5][8] != matrix[x5][x8]) return;
if(matrix[6][8] != matrix[x6][x8]) return;
if(matrix[7][8] != matrix[x7][x8]) return;
if(matrix[8][8] != matrix[x8][x8]) return;
store.state = true;
}

}
