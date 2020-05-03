
public class MatrixUDGUtil {
    char[] array;
    int[][] Matrix;
    
    

    public MatrixUDGUtil(char[] array) {
        this.array = array;
    }

    public MatrixUDGUtil(int[][] matrix) {
        Matrix = matrix;
    }

    public MatrixUDGUtil(char[] array, int[][] matrix) {
        this.array = array;
        Matrix = matrix;
    }

    /**
     * 获取数组中元素下标
     * @param e
     * @return
     */
    public Integer getPosition(char e){
        int n=array.length;
        for(int i=0;i<n;i++){
            if(e==array[i]){
                return i;
            }
        }
        return -1;
    }
    /**
     * 返回v的第一个邻接节点下标，失败返回-1
     */
    public Integer firstVertex(int v){
        if(v<0||v>array.length-1){
            return -1;
        }
        else{
            for(int i=0;i<array.length;i++){
                if(Matrix[v][i]!=0&&Matrix[v][i]!=Integer.MAX_VALUE){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * 返回v相对w的下一个邻接节点下标，失败返回-1
     */
    public Integer nextVertex(int v,int w){
        if(v<0||v>array.length-1||w>array.length-1){
            return -1;
        }
        else{
            for(int i=w+1;i<array.length;i++){
                if(Matrix[v][i]!=0&&Matrix[v][i]!=Integer.MAX_VALUE){
                    return i;
                }
            }
        }
        return -1;
    }

    

}