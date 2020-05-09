import java.util.Scanner;

public class MatrixUDG {
    private char[] mVers;    //顶点集合
    private Integer[][] mMatrix;  //邻接矩阵
    private static final int INF=Integer.MAX_VALUE;

    public MatrixUDG (){
        /**
         * 无参构造函数，需要写入
         */
        Scanner scanner=new Scanner(System.in);
        System.out.print("please enter the vertex number:");
        int lenOfVer=scanner.nextInt();
        System.out.print("please enter the edge number:");
        int lenOfEdge=scanner.nextInt();
        //check the input
        if(lenOfVer<1||lenOfEdge<1||lenOfEdge>lenOfVer*(lenOfVer-1)){
            System.out.println("非法简单图");
            scanner.close();
        }
        //input the vertex
        mVers=new char[lenOfVer];
        for(int i=0;i<lenOfVer;i++){
            char temp=scanner.next().charAt(0);
            mVers[i]=temp;
        }
        //初始化对角线
        mMatrix=new Integer[lenOfVer][lenOfVer];
        for(int i=0;i<lenOfVer;i++){
            for(int j=0;j<lenOfVer;j++){
                if(i==j){
                    mMatrix[i][j]=0;//初始化对角线为零
                }
                else{
                    mMatrix[i][j]=INF;
                    //初始化其他为整数对象的最大值,即无穷大，意味着不相邻即下面未处理者
                }
            }
        }
        //初始化权值
        for(int i=0;i<lenOfEdge;i++){//用户将边一次次输入，输入格式：起点，终点，权重
            System.out.print("请输入第"+(i+1)+"条边的信息，格式：起点顶点，终点顶点，权重；");
            char v1=scanner.next().charAt(0);
            char v2=scanner.next().charAt(0);
            Integer weight=scanner.nextInt();
            //MatrixUDGUtil getPositionUtil=new MatrixUDGUtil(mVers);
            Integer p1=MatrixUDGUtil.getPosition(mVers, v1);
            Integer p2=MatrixUDGUtil.getPosition(mVers, v2);
            if(p1==-1||p2==-1){
                System.out.println("Wrong Input!");
                return ;
            }
            //这里只考虑无向图，有向图不一样就可以了
            mMatrix[p1][p2]=weight;
            mMatrix[p2][p1]=weight;
        }
        scanner.close();
    }
    /**
     * 用两个字段来构造
     */

    public MatrixUDG(char[] mVers, Integer[][] mMatrix) {
        this.mVers = mVers;
        this.mMatrix = mMatrix;
    }

    public char[] get_mVers() {
        return mVers;
    }

    public void set_mVers(char[] mVers) {
        this.mVers = mVers;
    }

    public Integer[][] get_mMatrix() {
        return mMatrix;
    }

    public void set_mMatrix(Integer[][] mMatrix) {
        this.mMatrix = mMatrix;
    }
    
}