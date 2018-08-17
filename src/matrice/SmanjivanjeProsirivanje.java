package matrice;

public class SmanjivanjeProsirivanje
{
    public static void write(int[][] mat)
    {
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                System.out.printf("%3d", mat[i][j]);
            }
            System.out.println();
        }
    }
    
    public static int[][] increaseMatrix(int[][] mat, int i, int j)
    {
        int[][] newMat = new int[i][j];
        for(i=0; i<mat.length; i++){
            for(j=0; j<mat[i].length; j++){
                newMat[i][j] = mat[i][j];
            }
        }
        return newMat;
    }
    
    public static int[][] decreaseMatrix(int[][] mat, int ni, int nj)
    {
        int[][] newMat = new int[ni][nj];
        for(int i=0; i<ni; i++){
            for(int j=0; j<nj; j++)
                newMat[i][j] = mat[i][j];
        }
        return newMat;
    }
    
    public static int[][] changeMatrixDimensions(int[][] mat, int ni, int nj)
    {
        int[][] newMat = new int[ni][nj];
        int smallerI = ni < mat.length ? ni : mat.length;
        int smallerJ = nj < mat[0].length ? nj : mat[0].length;
        
        for(int i=0;i<smallerI; i++){
            for(int j=0; j<smallerJ; j++){
                newMat[i][j] = mat[i][j];
            }
        }
        return newMat;
    }
    
    public static void main(String[] args)
    {
        int[][] mat = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        write(mat);
        System.out.println("-----------------------------");
        mat = changeMatrixDimensions(mat, 2, 6);
        write(mat);
    }

}
