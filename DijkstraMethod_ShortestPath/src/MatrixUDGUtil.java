import java.util.Vector;

public class MatrixUDGUtil {
    //char[] array;
    //int[][] Matrix;
    
    

    /*public MatrixUDGUtil(char[] array) {
        this.array = array;
    }

    public MatrixUDGUtil(int[][] matrix) {
        Matrix = matrix;
    }

    public MatrixUDGUtil(char[] array, int[][] matrix) {
        this.array = array;
        Matrix = matrix;
    }*/

    /**
     * 获取数组中元素下标
     * @param e
     * @return
     */
    static public Integer getPosition(char[] array,char e){
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
    /*public Integer firstVertex(int v){
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
    }*/
    /**
     * 返回v相对w的下一个邻接节点下标，失败返回-1
     */
    static public Integer nextVertex(char[] array,Integer[][] Matrix,int v,int w){
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
    static public Vector<Integer> findNearVertex(char[] array,Integer[][] Matrix,int inputVertexIndex){
        Vector<Integer> store=new Vector<Integer>();
        if(inputVertexIndex<0||inputVertexIndex>=array.length){
            store.add(-1);//第一个是-1代表输入错误
            return store;
        }
        for(int i=0;i<array.length;i++){
            if(Matrix[inputVertexIndex][i]!=0&&Matrix[inputVertexIndex][i]!=Integer.MAX_VALUE){
                store.add(i);
            }
        }
        return store;
    }
    //仅供MinNode使用,返回元素里min最小的MinNode的下标,失败返回-1
    static public int findMinInArray(MinNode[] nodes){
        Integer mInteger=Integer.MAX_VALUE;
        int index=-1;
        int num=nodes.length;
        for(int i=0;i<num;i++){
            if(nodes[i].min<mInteger){
                mInteger=nodes[i].min;
                index=i;
            }
        }
        return index;
    }

    /*public char[] getArray() {
        return array;
    }

    public void setArray(char[] array) {
        this.array = array;
    }

    public int[][] getMatrix() {
        return Matrix;
    }

    public void setMatrix(int[][] matrix) {
        Matrix = matrix;
    }
    */
    //包含就输出对应的下标，不包含就输出-1
    static public int Contains(char[] array,char x){
        int num=array.length;
        for(int i=0;i<num;i++){
            if(x==array[i]){
                return i;
            }
        }
        return -1;
    }

    

}